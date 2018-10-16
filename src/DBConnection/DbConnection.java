package DBConnection;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnection {

    static Connection conn = null;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_USER_NAME = "blood_kerala";
    static final String DB_USER_NAME = "root";
//    static final String DB_PASSWORD = "12345";
    static final String DB_PASSWORD = "root123!";
//    static final String DB_NAME = "blood_db";
    static final String DB_NAME = "kot_db";
//    static final String DB_URL = "jdbc:mysql://107.180.46.169:3306/";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/";

    public static Connection getDbConnection() {

        try {

            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL + "" + DB_NAME, DB_USER_NAME, DB_PASSWORD);
            return conn;

        } catch (ClassNotFoundException ex1) {
            JOptionPane.showMessageDialog(null, "Error! Failed to Establish Connection! Please contact your System Administrator!\n\n" + ex1.getMessage(), "ERROR", 0);
            return null;

        } catch (SQLException ex2) {
            JOptionPane.showMessageDialog(null, "Error! Failed to Establish Connection! Please contact your System Administrator!\n\n" + ex2.getMessage(), "ERROR", 0);
            return null;

        } catch (Exception ex3) {
            JOptionPane.showMessageDialog(null, "Error! Failed to Establish Connection! Please contact your System Administrator!\n\n" + ex3.getMessage(), "ERROR", 0);
            return null;
        }
    }
}
