package com;


import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.CollectionInfo;
import com.Address;
import com.Employee;

public class ClientTest {

	public static void main(String[] args) {
		
		AbstractApplicationContext applicationContext = null;
		
		try {
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			CollectionInfo collectionInfo = applicationContext.getBean(CollectionInfo.class);
			
			System.out.println("getNames------------------------------");
			List<String> names = collectionInfo.getNames();
			names.forEach(System.out::println);
			
			System.out.println("getEmployeeList------------------------------");
			List<Employee> employeeList = collectionInfo.getEmployeeList();
			employeeList.forEach(System.out::println);
			
			System.out.println("getEmployeeSet------------------------------");
			Set<Employee> employeeSet = collectionInfo.getEmployeeSet();
			employeeSet.forEach(System.out::println);
			
			System.out.println("getEmployeeAddressMap------------------------------");
			Map<Employee, Address> employeeAddressMap = collectionInfo.getEmployeeAddressMap();
			employeeAddressMap.forEach((employee,address)->{
				System.out.println(employee);
				System.out.println(address);
			});
			
			System.out.println("getStateCaptital------------------------------");
			Properties stateCaptital = collectionInfo.getStateCaptital();
			stateCaptital.forEach((state,capital)->{
				System.out.println(state);
				System.out.println(capital);
			});
			System.out.println("getEmployeesArray------------------------------");
			Employee[] employeesArray = collectionInfo.getEmployeesArray();
			for (Employee employee : employeesArray) {
				System.out.println(employee);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(applicationContext != null) {
				applicationContext.close();
			}
		}
		
	}
}