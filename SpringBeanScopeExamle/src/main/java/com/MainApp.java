package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      //creating a Container.
      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
      // accessing bean from container

      objA.setMessage("I'm object A");
      objA.getMessage();

      HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
      objB.getMessage();
      // in case of singleton scope same message will print.
      // in case of prototype scope null will print beacuse new instance will create.
   }
}