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
        ResultSet avgrs = null;
        ResultSet maxRs = null;
        ResultSet minRs = null;
        ResultSet countRs = null;



        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected....!!!!!!!");
            stmt = connection.createStatement();

            // Sum of salaries for female employees
            String query = "SELECT SUM(salary) FROM employee_payroll WHERE gender='female' GROUP BY gender";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Total Salary of Female Employees: " + rs.getDouble(1));
            }

            // Average salary for female employees
            System.out.println("Average of salary");
            avgrs = stmt.executeQuery("SELECT gender, AVG(salary) FROM employee_payroll WHERE gender='female' GROUP BY gender");
            while (avgrs.next()) {
                System.out.println("Gender: " + avgrs.getString(1));
                System.out.println("Average Salary: " + avgrs.getDouble(2));
            }


            maxRs = stmt.executeQuery("SELECT MAX(salary) FROM employee_payroll");
            while (maxRs.next()) {
                System.out.println("Maximum Salary: " + maxRs.getDouble(1));
            }

            minRs = stmt.executeQuery("SELECT MIN(salary) FROM employee_payroll");
            while (minRs.next()) {
                System.out.println("Minimum Salary: " + minRs.getDouble(1));
            }
            countRs = stmt.executeQuery("SELECT COUNT(*) FROM employee_payroll");
            while (countRs.next()) {
                System.out.println("COUNT OF EMPLOYEE: " + countRs.getInt(1));
            }


            System.out.println("READ SUCCESSFUL!");

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (avgrs != null) avgrs.close();
                if (maxRs != null) maxRs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}

