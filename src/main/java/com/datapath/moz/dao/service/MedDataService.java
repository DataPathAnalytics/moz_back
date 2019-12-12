package com.datapath.moz.dao.service;

import com.datapath.moz.dao.entity.MedDataEntity;
import com.datapath.moz.dao.repository.MedDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MedDataService {

    @Autowired
    private MedDataRepository repository;

    public Boolean exist(String mnn, String dosage, String form, String unit) {
        return repository.existsByMnnAndDosageAndFormAndUnit(mnn, dosage, form, unit);
    }

    public Set<MedDataEntity> getByFields(String mnn, String dosage, String form) {
        return new HashSet<>(repository.findBySomeFields(mnn, dosage, form));
    }
}
