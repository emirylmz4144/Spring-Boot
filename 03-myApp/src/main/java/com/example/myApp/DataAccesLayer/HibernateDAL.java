package com.example.myApp.DataAccesLayer;

import com.example.myApp.Entities.City;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Repo ve kaynak sınıfı olduğu uygun anotasyonlarla bildiriliyor
@Repository
@Resource
public class HibernateDAL implements IDataAcces{

    //EntityMeanger sınıfı ile Session yönetiliyor
    public EntityManager entityManager;

    @Autowired
    public HibernateDAL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Bir AOP anotasyonu olan @Transaction ile trasaction açma ve kapama işlemini metodun içinde
    //metot başı ve sonuna spring otommotik olarak ekliyor
    @Transactional
    @Override
    public List<City> getAll() {
        Session session=entityManager.unwrap(Session.class);
       List<City> cities=session.createQuery("from City ",City.class).getResultList();
       return cities;
    }

    @Override
    @Transactional
    public void add(City city) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        Session session=entityManager.unwrap(Session.class);
        City deleteToCity=session.get(City.class,city.getId());
        session.delete(deleteToCity);
    }

    @Override
    public City getById(int id) {
        Session session=entityManager.unwrap(Session.class);
        return session.get(City.class, id);
    }


}
