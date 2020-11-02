package com.police.entity;
// Generated 28-Jul-2017 00:58:18 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Case generated by hbm2java
 */
@Entity
@Table(name = "CASE",
         schema = "MONIR"
)
public class Case implements java.io.Serializable {

    private BigDecimal id;
    private String type;
    private String crimeDate;
    private String caseDate;
    private String victim;
    private String victimAge;
    private String district;
    private String division;
    private String officer;
    private String caseName;
    private String policeStation;

    public Case() {
    }

    public Case(BigDecimal id) {
        this.id = id;
    }

    public Case(BigDecimal id, String type, String crimeDate, String caseDate, String victim, String victimAge, String district, String division, String officer, String caseName, String policeStation) {
        this.id = id;
        this.type = type;
        this.crimeDate = crimeDate;
        this.caseDate = caseDate;
        this.victim = victim;
        this.victimAge = victimAge;
        this.district = district;
        this.division = division;
        this.officer = officer;
        this.caseName = caseName;
        this.policeStation = policeStation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CASE_SEQ")
    @SequenceGenerator(name = "CASE_SEQ", sequenceName = "CASE_SEQ", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false, precision = 20, scale = 0)
    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Column(name = "TYPE", length = 80)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "CRIME_DATE", length = 50)
    public String getCrimeDate() {
        return this.crimeDate;
    }

    public void setCrimeDate(String crimeDate) {
        this.crimeDate = crimeDate;
    }

    @Column(name = "CASE_DATE", length = 50)
    public String getCaseDate() {
        return this.caseDate;
    }

    public void setCaseDate(String caseDate) {
        this.caseDate = caseDate;
    }

    @Column(name = "VICTIM", length = 100)
    public String getVictim() {
        return this.victim;
    }

    public void setVictim(String victim) {
        this.victim = victim;
    }

    @Column(name = "VICTIM_AGE", length = 20)
    public String getVictimAge() {
        return this.victimAge;
    }

    public void setVictimAge(String victimAge) {
        this.victimAge = victimAge;
    }

    @Column(name = "DISTRICT", length = 50)
    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Column(name = "DIVISION", length = 50)
    public String getDivision() {
        return this.division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Column(name = "OFFICER", length = 100)
    public String getOfficer() {
        return this.officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    @Column(name = "CASE_NAME", length = 100)
    public String getCaseName() {
        return this.caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Column(name = "POLICE_STATION", length = 100)
    public String getPoliceStation() {
        return this.policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

}