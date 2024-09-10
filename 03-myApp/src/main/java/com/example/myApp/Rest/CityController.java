package com.example.myApp.Rest;

import com.example.myApp.Business.ICityService;
import com.example.myApp.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController olduğu bildiriliyor
@RestController
@RequestMapping("/api")//default url yoluna ekleme yapılıyor
public class CityController {

    ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> getAll()
    {
       return cityService.getAll();
    }


    @PostMapping("/add")
    public void add(@RequestBody City city)
    {
        cityService.add(city);
    }


    @PostMapping("/update")
    public void update(@RequestBody City city)
    {
        cityService.update(city);
    }


    @DeleteMapping("/delete")
    public void delete(@RequestBody City city)
    {
        cityService.delete(city);
    }

    //Path variable ile id'nin dosya yolundan geleceği bildiriliyor
    @GetMapping("/cities/{id}")
    public City getById(@PathVariable int id)
    {
        return cityService.getById(id);
    }
}
