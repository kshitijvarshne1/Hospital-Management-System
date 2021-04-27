/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Apr-21
 *   Time: 5:04 PM
 *   File: DbOperations.java
 */

package com.example.hospitalmanagementsystem.Repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class DbOperations {
    private static final String URL = "jdbc:mysql://localhost:3306/patientsDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1122";
    private static Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            connection = null;
        }
    }

}

