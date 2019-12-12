package com.datapath.moz.dao.repository;

import com.datapath.moz.dao.entity.MatchingResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingResultRepository extends JpaRepository<MatchingResultEntity, Integer> {

    List<MatchingResultEntity> findAllByOrderById();
}
