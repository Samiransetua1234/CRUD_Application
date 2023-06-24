package com.jspider.crud_practice.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class UpdateStudentDataController {
	static Connection connection = null;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the student Id to update the email : ");
		int id = scanner.nextInt();
		System.out.println("Enter the new email to be updated : ");
		long email = scanner.nextLong();
		try {
			// Step-1 load/ register driver
			
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step-2 create connection 
			String url = "jdbc:mysql://localhost:3306/jdbc_practice";
			String user = "root";
			String pass = "root1234";
			
			connection = DriverManager.getConnection(url, user, pass);
			
			//Step-3  create statement
			Statement statement = connection.createStatement();
			
			String updateStudentQuerry = "UPDATE student SET phone = '"+email+"' WHERE id = "+id;
			
			int x = statement.executeUpdate(updateStudentQuerry);
			if(x == 1) {
				System.out.println("Data Update Sucessful!");
			}else {
				System.out.println("You have entered a invalid ID, please provide a valid ID");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
