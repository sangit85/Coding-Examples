package com;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 
@SuppressWarnings("resource") 

public class Test {  
    public static void main(String[] args) {  
          
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Context object is IOC Container
		Employee emp = (Employee)context.getBean("emp");
    	
       
 
        emp.show();  
        
     
        
          
    }  
}  