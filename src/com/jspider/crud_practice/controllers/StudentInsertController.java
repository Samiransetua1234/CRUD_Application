package com.jspider.crud_practice.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;



public class StudentInsertController {
	static Connection connection = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the name of the student");
		String name = scanner.next();

		System.out.println("Enter the email of the student");
		String email = scanner.next();

		System.out.println("Enter the phone no ");
		long phone = scanner.nextLong();

		try {
			// Step-1 load/register the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Step-2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc_practice";
			String user = "root";
			String pass = "root1234";

			connection = DriverManager.getConnection(url, user, pass);

			// Step-3 create statement
			Statement statement = connection.createStatement();

			// Step-4 ExecuteQuery

			String inserStudentQuery = "insert into student (name, email, phone) values('"+name+"', '"+email+"', "+phone+")";
			statement.execute(inserStudentQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Data inserted successfully!");
		}
	}

}
