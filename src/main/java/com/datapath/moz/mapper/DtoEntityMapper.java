package com.datapath.moz.mapper;

import com.datapath.moz.dao.entity.MatchingResultEntity;
import com.datapath.moz.dao.entity.MedDataEntity;
import com.datapath.moz.dto.MedDataDTO;
import com.datapath.moz.dto.NomenclatureDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface DtoEntityMapper {

    List<MedDataDTO> map(Set<MedDataEntity> entity);

    MatchingResultEntity map(NomenclatureDTO dto);

    List<NomenclatureDTO> map(List<MatchingResultEntity> entities);
}
