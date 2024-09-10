package com.example.myApp.Business;

import com.example.myApp.DataAccesLayer.IDataAcces;
import com.example.myApp.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityMenager implements ICityService{

    private IDataAcces dataAcces;

    @Autowired
    public CityMenager(IDataAcces dataAcces) {
        this.dataAcces = dataAcces;
    }
    @Override
    @Transactional
    public List<City> getAll() {
        return this.dataAcces.getAll();
    }

    @Override
    @Transactional
    public void add(City city) {
        this.dataAcces.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        this.dataAcces.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        this.dataAcces.delete(city);
    }

    @Override
    @Transactional
    public City getById(int id) {
       return this.dataAcces.getById(id);
    }
}
