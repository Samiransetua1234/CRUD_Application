package com.jspider.crud_practice.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class StudentDisplayController {

	static Connection connection = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc_practice";
			String user = "root";
			String pass = "root1234";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String displayAllStudentQuery = "SELECT * FROM student";

			ResultSet resultSet = statement.executeQuery(displayAllStudentQuery);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				long phone = resultSet.getLong("phone");

				System.out.println("Student ID = " + id + ", Student Name = " + name + ", Student Email = " +email
						+ ", Student Phone No. = " + phone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
