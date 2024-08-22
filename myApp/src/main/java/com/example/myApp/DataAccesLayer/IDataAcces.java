package com.example.myApp.DataAccesLayer;

import com.example.myApp.Entities.City;

import java.util.List;

public interface IDataAcces
{
    List<City>  getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
}
