package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	// Database URL
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";

    // Database Username
    private static final String USERNAME = "root";

    // Database Password
    private static final String PASSWORD = "root";

    // Method to establish database connection
    public static Connection getConnection() {

        Connection con = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database Connected Successfully...");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver Not Found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return con;
    }

    // Method to close the connection
    public static void closeConnection(Connection con) {

        try {

            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Database Connection Closed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
