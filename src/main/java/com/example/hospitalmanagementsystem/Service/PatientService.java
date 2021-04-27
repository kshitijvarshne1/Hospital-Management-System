/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Apr-21
 *   Time: 5:01 PM
 *   File: PatientService.java
 */

package com.example.hospitalmanagementsystem.Service;

import com.example.hospitalmanagementsystem.Model.Patient;
import com.example.hospitalmanagementsystem.Repository.DbOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    DbOperations dbOperations;

    public String createTable(String tableName) throws SQLException {
        return dbOperations.createTable(tableName);
    }

    public String insertPatientInfo(Patient patient) throws SQLException {
        return dbOperations.insertPatientInfo(patient);
    }

    public List<Patient> getAllPatientInfo() throws SQLException {
        return dbOperations.getAllPatientInfo();
    }

    public Patient searchById(int id) throws SQLException {
        return dbOperations.searchById(id);
    }
}

