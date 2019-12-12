package com.datapath.moz.reader.excel;

import com.datapath.moz.dto.NomenclatureDTO;
import com.datapath.moz.reader.FileReader;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.datapath.moz.reader.excel.ExcelUtils.generateNomenclaturesFromFile;
import static com.datapath.moz.reader.excel.ExcelUtils.getStringFromCell;
import static org.springframework.util.StringUtils.isEmpty;

@Service
public class ExcelReader implements FileReader {

    @Override
    public List<NomenclatureDTO> getNomenclaturesFromFile(MultipartFile file) throws IOException {
        List<NomenclatureDTO> nomenclatures = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();

        for (int i = 1; i <= lastRowNum; i++) {
            String mnn = getStringFromCell(sheet.getRow(i).getCell(5));
            if (isEmpty(mnn)) continue;
            nomenclatures.add(generateNomenclaturesFromFile(sheet.getRow(i), mnn));
        }
        return nomenclatures;
    }
}
