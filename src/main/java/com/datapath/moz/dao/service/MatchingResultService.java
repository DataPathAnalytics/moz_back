package com.datapath.moz.dao.service;

import com.datapath.moz.dao.entity.MatchingResultEntity;
import com.datapath.moz.dao.repository.MatchingResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchingResultService {

    @Autowired
    private MatchingResultRepository repository;

    public void save(MatchingResultEntity entity) {
        repository.save(entity);
    }

    public List<MatchingResultEntity> get() {
        return repository.findAllByOrderById();
    }

    public void clear() {
        repository.deleteAll();
    }
}
