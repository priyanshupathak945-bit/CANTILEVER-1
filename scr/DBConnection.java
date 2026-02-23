package scr;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            // MySQL JDBC Driver load
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarymanagementdb1",
                    "root",
                    "Priyanshu2709#"
            );

            System.out.println("Database Connected");

        } catch (Exception e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return con;
    }
}


