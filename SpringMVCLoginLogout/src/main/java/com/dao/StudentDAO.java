package com.dao;



import com.model.Student;

public interface StudentDAO {

 public void registerStudent(Student student);
 
 public Student loginStudent(Student student);
}