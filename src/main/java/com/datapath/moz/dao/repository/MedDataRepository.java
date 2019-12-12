package com.datapath.moz.dao.repository;

import com.datapath.moz.dao.entity.MedDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedDataRepository extends JpaRepository<MedDataEntity, Integer> {
    Boolean existsByMnnAndDosageAndFormAndUnit(String mnn, String dosage, String form, String unit);

    @Query(value = "select *\n" +
            "from med_data\n" +
            "where (mnn is not null and\n" +
            "       length(mnn) = length(:mnn) and\n" +
            "       substr(mnn, 1, 2) = substr(:mnn, 1, 2) and\n" +
            "       substr(mnn, length(mnn)) = substr(:mnn, length(:mnn)))\n" +
            "   or (dosage is not null and dosage = CAST (:dosage AS TEXT) and form is not null and form = CAST (:form AS TEXT));", nativeQuery = true)
    List<MedDataEntity> findBySomeFields(@Param("mnn") String mnn, @Param("dosage") String dosage, @Param("form") String form);
}
