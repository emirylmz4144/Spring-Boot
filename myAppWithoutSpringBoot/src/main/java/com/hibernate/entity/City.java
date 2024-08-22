package com.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class City
{


    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "CountryCode")
    private  String countryCode;

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private int population;

    public City() {
    }

    public City(String name,String countryCode, String district ,int population) {
        this.id = id;
        this.population = population;
        this.district = district;
        this.countryCode = countryCode;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    @Override
    public String toString() {
        return "Şehir Adı: "+name+"\nÜlke Kodu: "+countryCode+"\nSemt: "+district+"\nPopülasyon"+population;
    }
}
