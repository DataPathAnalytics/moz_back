package com.datapath.moz.service;

import com.datapath.moz.dao.entity.MatchingResultEntity;
import com.datapath.moz.dao.entity.MedDataEntity;
import com.datapath.moz.dao.service.MatchingResultService;
import com.datapath.moz.dao.service.MedDataService;
import com.datapath.moz.dto.MatchingResultDTO;
import com.datapath.moz.dto.NomenclatureDTO;
import com.datapath.moz.mapper.DtoEntityMapper;
import com.datapath.moz.reader.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class MatchingWebService {

    @Autowired
    private MedDataService medDataService;
    @Autowired
    private MatchingResultService matchingResultService;
    @Autowired
    private DtoEntityMapper mapper;
    @Autowired
    private FileReader reader;

    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors() - 1;

    public List match(MultipartFile file) throws IOException, InterruptedException {
        List<MatchingResultDTO> matchingResults = new ArrayList<>();
        List<NomenclatureDTO> nomenclatures = reader.getNomenclaturesFromFile(file);
        if (!isEmpty(nomenclatures)) {
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
            CountDownLatch countDownLatch = new CountDownLatch(nomenclatures.size());
            for (NomenclatureDTO nomenclature : nomenclatures) {
                executor.execute(() -> {
                    if (medDataService.exist(nomenclature.getMnn(),
                            nomenclature.getDosage(),
                            nomenclature.getForm(),
                            nomenclature.getUnit())) {
                        MatchingResultEntity resultEntity = mapper.map(nomenclature);
                        matchingResultService.save(resultEntity);
                    } else {
                        Set<MedDataEntity> medDataEntities = medDataService.getByFields(nomenclature.getMnn(),
                                nomenclature.getDosage(),
                                nomenclature.getForm());
                        if (!isEmpty(medDataEntities)) {
                            MatchingResultDTO matchingResult = new MatchingResultDTO();
                            matchingResult.setNomenclature(nomenclature);
                            matchingResult.setMedData(mapper.map(medDataEntities));
                            matchingResults.add(matchingResult);
                        }
                    }
                    countDownLatch.countDown();
                });
            }
            countDownLatch.await();
        }
        return matchingResults;
    }

    public void save(NomenclatureDTO dto) {
        matchingResultService.save(mapper.map(dto));
    }

    public List get() {
        return mapper.map(matchingResultService.get());
    }

    public void clear() {
        matchingResultService.clear();
    }
}
