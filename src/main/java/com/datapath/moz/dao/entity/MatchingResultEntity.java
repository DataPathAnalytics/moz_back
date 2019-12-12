package com.datapath.moz.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "matching_result")
@AllArgsConstructor
@NoArgsConstructor
public class MatchingResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer column2;
    private String column3;
    private String column4;
    private String direction;
    private String subDirection;
    private String mnn;
    private String form;
    private String dosage;
    private String extraListDosage;
    private String unit;
    private Float cost;
    private Integer uah;
    private Integer column12;
    private Integer vinnytsa;
    private Integer volyn;
    private Integer dnipropetrovsk;
    private Integer donetsk;
    private Integer zhytomyr;
    private Integer zakarpattia;
    private Integer zaporizhia;
    private Integer ivanoFrankivsk;
    private Integer kiev;
    private Integer kirovograd;
    private Integer lugansk;
    private Integer lviv;
    private Integer nikolaev;
    private Integer odessa;
    private Integer poltava;
    private Integer rivne;
    private Integer sumy;
    private Integer ternopil;
    private Integer kharkiv;
    private Integer kherson;
    private Integer khmelnytsky;
    private Integer cherkassy;
    private Integer chernivtsi;
    private Integer chernihiv;
    private Integer sityKyiv;
    private Integer hip;//Національний інститут раку МОЗ України
    private Integer ndsl;//НДСЛ Охматдит
    private Integer dzpcrl;//ДЗ «Прикарпатський центр репродукції людини» МОЗ України
    private Integer onmu;//Одеський НМУ (Центр реконструктивної та відновної медицини (Університетська клініка))
    private Integer hmapo;//НМАПО ім.П.Л.Шупика (Український державний інститут репродуктології)
    private Integer dzumcagr;//ДЗ «Український медичний центр акушерства гінекології та репродуктології Міністерства охорони здоров’я України»
    private Integer dnmu;//Донецький інститут ортопедії і травмотології МОЗ України Донецького державного медичного університету ім. М.Горького
    private Integer npmcdkk;//Науково-практичний медичний центр дитячої кардіології та кардіохірургії
    private Integer ismozu;//Інститут сердця МОЗ України
    private Integer kct;//Кординаційний центр трансплантації
    private Integer duucsocmoz;//ДУ УКРАЇНСЬКИЙ ЦЕНТРКОНТРОЛЮ ЗА СОЦ ХВОРОБАМИ МОЗ УКРАЇНИ""
}
