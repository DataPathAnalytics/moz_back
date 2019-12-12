package com.datapath.moz.reader;

import com.datapath.moz.dto.NomenclatureDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileReader {

    List<NomenclatureDTO> getNomenclaturesFromFile(MultipartFile file) throws IOException;
}
