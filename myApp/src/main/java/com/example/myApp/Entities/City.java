package com.example.myApp.Entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

//Varlık sınıfı olduğunu bildirmek için ilgili anotasyonu ekledik
@Entity
//Veri tabanından hangi tabloya gideceğini bildirdik
@Table(name = "city")
public class City {

    @Id
    @Column(name = "id")//veri tabanında ilgili kolonu alıyor
    @GeneratedValue(strategy = GenerationType.IDENTITY)//otomotik artacağı bildiriliyor
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "countrycode")
    private String countryCode;

    @Column(name = "district")
    private String district;

    @Column(name = "population")
    private int population;

    /*Unutmaman gerekeken şey column anotasyonu içinde belirtilen kolonlara veri tabanında
    * gider ve veri tabanı mantığı gereğinde alınan nesneye veri tabanı instance oluşturur
    * ve bu veri tabanı instance ise belirtilen column isimleriyle ;
    *   1-isim tekse direkt alır
    *   2-isim uzunsa countrycode=country_code şeklinde isimlendirir
    * bu yüzden çoklu isim verince CountrCode şeklinde falan yapma çünkü bulamaz
    * countrycode şeklinde küçük harf duyarlı yap*/

    public City() {}

    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
