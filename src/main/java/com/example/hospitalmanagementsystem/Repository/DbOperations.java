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
import java.sql.Statement;

@Repository
public class DbOperations {
    private static final String URL = "jdbc:mysql://localhost:3306/patientsDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1122";
    private static Connection connection;

    public void getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
    }

    public void closeConnection() {
        if (connection != null) {
            connection = null;
        }
    }

    public String createTable(String tableName) throws SQLException {
        getConnection();
        Statement statement = connection.createStatement();
        boolean isOpSucc = statement.execute("CREATE TABLE " + tableName + " (id INT primary key AUTO_INCREMENT,patientName varchar(20),allocatedRoomNo INT,allocatedDoctorName VARCHAR(20),dateOfAdmit VARCHAR(20) ); ");
        String str = tableName + " is ";
        if (isOpSucc) {
            str = str + "created Successfully";
        } else {
            str = str + "not created Successfully";
        }
        return str;
    }
}

