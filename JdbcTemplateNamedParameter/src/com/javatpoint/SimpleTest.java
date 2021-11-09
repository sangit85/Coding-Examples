package com.javatpoint;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SimpleTest {
  public static void main(String[] args) {
	
	  ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDao dao=(EmpDao)ctx.getBean("edao");
		dao.save(new Emp(27,"sonoo",50000));
	
  }
}