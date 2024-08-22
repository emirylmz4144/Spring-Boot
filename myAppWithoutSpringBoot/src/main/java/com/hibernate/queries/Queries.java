package com.hibernate.queries;

import com.hibernate.entity.City;
import com.hibernate.DbConfig.DBContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class Queries
{
    private static Scanner datas = new Scanner(System.in);

    public static void CREATE_CITY() {
        Session session = DBContext.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.println("Şehir : "); String cityName = datas.nextLine();
            System.out.println("Ülke Kodu(3 harfli kod) : "); String country = datas.nextLine();
            System.out.println("Semt : "); String district = datas.nextLine();
            System.out.println("Popülasyon : "); int population = datas.nextInt();
            datas.nextLine(); // Consume newline
            City city = new City(cityName, country, district, population);
            session.save(city);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void GET_CITIES() {
        Session session = DBContext.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<City> cities = session.createQuery("from City", City.class).getResultList();
            transaction.commit();
            for (City city : cities) {
                System.out.println(city);
                System.out.println("-----------------------------------------------");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void UPDATE_CITY() {
        Session session = DBContext.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.println("Id numarasını giriniz: "); int id = datas.nextInt(); datas.nextLine();
            City city = session.get(City.class, id);
            System.out.println("Şehir adı : "); city.setName(datas.nextLine());
            System.out.println("Ülke Kodu(3 harfli kod) : "); city.setCountryCode(datas.nextLine());
            System.out.println("Semt Adı : "); city.setDistrict(datas.nextLine());
            System.out.println("Popülasyon : "); city.setPopulation(datas.nextInt());
            datas.nextLine(); // Consume newline
            session.update(city);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void DELETE_CITY() {
        Session session = DBContext.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.println("Şehir id giriniz : "); int id = datas.nextInt();
            City deletedCity = session.get(City.class, id);
            if (deletedCity != null) {
                session.delete(deletedCity);
                transaction.commit();
            } else {
                System.out.println("Şehir bulunamadı!");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
