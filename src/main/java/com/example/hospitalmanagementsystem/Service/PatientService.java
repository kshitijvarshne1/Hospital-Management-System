/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Apr-21
 *   Time: 5:01 PM
 *   File: PatientService.java
 */

package com.example.hospitalmanagementsystem.Service;

import com.example.hospitalmanagementsystem.Repository.DbOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PatientService {

    @Autowired
    DbOperations dbOperations;

    public String createTable(String tableName) throws SQLException {
        return dbOperations.createTable(tableName);
    }
}

