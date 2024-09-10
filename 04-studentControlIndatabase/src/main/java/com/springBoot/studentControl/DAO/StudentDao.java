package com.springBoot.studentControl.DAO;

import com.springBoot.studentControl.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDao implements StudentDaoService
{
    EntityManager entityManager;

    @Autowired
    public StudentDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Transactional
    @Override
    public List<Student> getAll() {
        TypedQuery<Student> typedQuery=entityManager.createQuery("FROM Student",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public void findBySurname(String surname) {
        TypedQuery<Student> typedQuery=entityManager.createQuery("from Student where lastName=:wantedData",Student.class);
        typedQuery.setParameter("wantedData", surname);
        for (Student student : typedQuery.getResultList()) {
            System.out.println(student);
        }
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberOfDeleted=entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numberOfDeleted;
    }


}