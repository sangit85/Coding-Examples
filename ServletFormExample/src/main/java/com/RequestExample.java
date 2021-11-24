package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;


/**
 * Servlet implementation class RequestExample
 */
@WebServlet("/RequestExample")

public class RequestExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// implementation of service()  method.
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
			{  
			res.setContentType("text/html");  
			
			PrintWriter pw=res.getWriter();  
			  
			String firstname=req.getParameter("firstname");//will return value
			String lastname=req.getParameter("lastname");
			String coursename=req.getParameter("coursename");
			String location=req.getParameter("location");
			
			pw.println("Welcome "+firstname);
			pw.println("Welcome "+lastname);
			pw.println("Cousrename"+coursename);
			pw.println("location"+location);
			
			  
			pw.close();  
			}
	
	
    public RequestExample() {
        super();
        // TODO Auto-generated constructor stub
    }

}
