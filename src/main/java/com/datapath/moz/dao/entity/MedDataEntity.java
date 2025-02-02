package com.datapath.moz.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "med_data")
@EqualsAndHashCode(exclude = "id")
public class MedDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mnn;
    private String dosage;
    private String unit;
    private String form;
}
