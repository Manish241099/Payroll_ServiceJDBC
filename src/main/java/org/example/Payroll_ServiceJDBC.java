package org.example;

import java.sql.*;

public class Payroll_ServiceJDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "Indian@123";

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected....!!!!!!!");

            String queryUpdate = "UPDATE employee_payroll SET Basic_pay = '3000000' WHERE name = 'Manish'";
            stmt = connection.createStatement();
            int rowAffected= stmt.executeUpdate(queryUpdate);
            System.out.println("ROW AFFECTED"+rowAffected);
            String query="SELECT * FROM employee_payroll";
            stmt=connection.createStatement();
            rs=stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt(1));
                System.out.println("Employee Name: " + rs.getString(2));
                System.out.println("Salary: " + rs.getInt(3));
                System.out.println("Start Date: " + rs.getDate(4));
                System.out.println("Age: " + rs.getInt(5));
                System.out.println("Gender: " + rs.getString(6));
                System.out.println("Phone No: " + rs.getString(7));
                System.out.println("Address: " + rs.getString(8));
                System.out.println("Department: " + rs.getString(9));
                System.out.println("Basic Pay: " + rs.getString(10));
                System.out.println("Deduction: " + rs.getString(11));
                System.out.println("Taxable Pay: " + rs.getString(12));
                System.out.println("Income Tax: " + rs.getString(13));
                System.out.println("Net Pay: " + rs.getString(14));
                System.out.println();
            }
            System.out.println("READ SUCCESSFUL!");

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
