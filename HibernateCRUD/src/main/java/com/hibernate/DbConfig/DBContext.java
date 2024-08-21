package com.hibernate.DbConfig;

import com.hibernate.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBContext
{
    private static SessionFactory sessionFactory;
    private static Session session;
    private static SessionFactory getSessionFactory(){
        sessionFactory = new Configuration().
                         configure("hibernate.cfg.xml").
                         addAnnotatedClass(City.class).
                         buildSessionFactory();

        return sessionFactory;
    }

    public static Session  getSession(){
      return session=getSessionFactory().getCurrentSession();
    }

}
