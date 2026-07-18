package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	

    // Database URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/leave_management";

    // MySQL Username
    private static final String USER = "root";

    // MySQL Password
    private static final String PASSWORD = "root";

    // Method to get database connection
    public static Connection getConnection() {

        Connection con = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return con;
    }

    // Method to close connection
    public static void closeConnection(Connection con) {

        if (con != null) {

            try {
                con.close();
                System.out.println("Connection Closed Successfully!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
