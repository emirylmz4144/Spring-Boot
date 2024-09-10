package com.springBoot.studentControl.DAO;

import com.springBoot.studentControl.entity.Student;

import java.util.List;

public interface StudentDaoService
{
    public void save(Student student);
    public Student getById(Integer id);
    public List<Student> getAll();
    public void findBySurname(String surname);
    public void update(Student student);
    public void delete(Integer id);
    public int deleteAll();
}
