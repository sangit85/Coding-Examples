package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//import javax.persistence.Parameter;
//import javax.persistence.Query;

public class Hiber 
{

	public static void main(String[] args) 
	{

	SessionFactory sf=  new Configuration().configure().buildSessionFactory();  
	Session session = sf.openSession();
	
	//Creating the first object
	UserInfo ob1 = new UserInfo();
	ob1.setFirstName("First");
	ob1.setLastName("User");

	
	//Creating the second object
	UserInfo ob2 = new UserInfo();
	ob2.setFirstName("Second");
	ob2.setLastName("User");

	
	//Creating the third object
	UserInfo ob3 = new UserInfo();
	ob3.setFirstName("Third");
	ob3.setLastName("User");

	

	session.beginTransaction();
	session.save(ob1); //Saving the first object
	session.save(ob2); //Saving the second object
	session.save(ob3); //Saving the third object
	session.getTransaction().commit();
	session.close();
	
	
	//Retrieve and displaying a particular user details.
	session = sf.openSession();
	session.beginTransaction();
	Query query1 = session.createQuery("from UserInfo");

	List<UserInfo> collection1 = query1.getResultList();
	System.out.println("Retrieving a particular object where 'firstName' property has 'First' value");
	for(UserInfo object : collection1)
	{
		System.out.println("Id : " + object.getId());
		System.out.println("First Name : " + object.getFirstName());
		System.out.println("Last Name : " + object.getLastName());	
		System.out.println();
	}
		
		
		
	session.getTransaction().commit();
	
	
	//closing the session
	session.close();
}
}