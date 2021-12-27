package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDAO;
import com.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

 @Autowired
 private StudentDAO studentDao;
 @Override
 @Transactional
 public void registerStudent(Student student) {
  // TODO Auto-generated method stub
  studentDao.registerStudent(student);
 }

 @Override
 public Student loginStudent(Student student) {
  // TODO Auto-generated method stub
  return studentDao.loginStudent(student);
 }

}