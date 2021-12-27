package com.dao;



import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Student;
@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO{

 @Autowired
 private SessionFactory factory;
 @Override
 public void registerStudent(Student student) {
  // TODO Auto-generated method stub
  Session session = factory.getCurrentSession();
  session.save(student);
 }

 @Override
 public Student loginStudent(Student student) {
  // TODO Login
  Session session = factory.getCurrentSession();
  try {
  Query<Student> query = session.createQuery("from Student where userName =:userName and password =:password",Student.class);
  query.setParameter("userName", student.getUserName());
  query.setParameter("password", student.getPassword());
  student = query.setMaxResults(1).uniqueResult();
  return student;
  }catch (NoResultException e) {
   // TODO: handle exception
   return null;
  }
 }
}