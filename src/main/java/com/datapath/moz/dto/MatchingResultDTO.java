package com.datapath.moz.dto;

import lombok.Data;

import java.util.List;

@Data
public class MatchingResultDTO {
    private NomenclatureDTO nomenclature;
    private List<MedDataDTO> medData;

}
