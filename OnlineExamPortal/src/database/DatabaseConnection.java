package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created By: shubham singh
 * User ID: shubham410226
 * Package Name: main
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 07-03-2024
 */

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/onlineassessment";
    private static final String root = "root";
    private static final String password = "";

    private static Connection connection;

    /**
     * This method return an instance of Connection type.
     *
     * @return connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * This method do the connection to database.
     */
    public static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(URL, root, password);
            System.out.println("Database connected Successfully");
        } catch (SQLException e) {
            System.err.println("Couldn't connect to database.");
            e.printStackTrace();
        }
    }

}
