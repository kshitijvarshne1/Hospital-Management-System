/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Apr-21
 *   Time: 5:04 PM
 *   File: DbOperations.java
 */

package com.example.hospitalmanagementsystem.Repository;

import com.example.hospitalmanagementsystem.Model.Patient;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DbOperations {
    private static final String URL = "jdbc:mysql://localhost:3306/book";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1122";
    private static Connection connection;
    private String tableName;

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
        this.tableName = tableName;
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

    public String insertPatientInfo(Patient patient) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + this.tableName + " VALUES (NULL, ?,?,?,?)");
        preparedStatement.setString(1, patient.getPatientName());
        preparedStatement.setInt(2, patient.getAllocatedRoomNo());
        preparedStatement.setString(3, patient.getAllocatedDoctorName());
        preparedStatement.setString(4, patient.getDateOfAdmit());
        int row = preparedStatement.executeUpdate();
        String str;
        if (row < 1) {
            str = "patient info is not inserted";
        } else {
            str = " patient info  is inserted successfully";
        }
        closeConnection();
        return str;
    }

    public List<Patient> getAllPatientInfo() throws SQLException {
        getConnection();
        List<Patient> patients = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //int id = resultSet.getInt(1);
            String patientName = resultSet.getString(2);
            int allocatedRoomNo = resultSet.getInt(3);
            String allocatedDoctorName = resultSet.getString(4);
            String dateOfAdmit = resultSet.getString(5);
            patients.add(new Patient(patientName, allocatedRoomNo, allocatedDoctorName, dateOfAdmit));
        }
        closeConnection();
        return patients;
    }

    public Patient searchById(int id) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE id = " + id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String patientName = resultSet.getString(2);
            int allocatedRoomNo = resultSet.getInt(3);
            String allocatedDoctorName = resultSet.getString(4);
            String dateOfAdmit = resultSet.getString(5);
            Patient patient = new Patient(patientName, allocatedRoomNo, allocatedDoctorName, dateOfAdmit);
            closeConnection();
            return patient;
        } else {
            System.out.println("Not found");
            closeConnection();
            return null;
        }

    }

    public String dischargePatient(int id) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + this.tableName + " WHERE id = " + id);
        boolean isOpSucc = preparedStatement.execute();
        if (isOpSucc) {
            return "Deleted";
        } else {
            return "Not deleted";
        }
    }
}

