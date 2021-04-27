/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Apr-21
 *   Time: 4:48 PM
 *   File: PatientController.java
 */

package com.example.hospitalmanagementsystem.Controller;

import com.example.hospitalmanagementsystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/createTable/{tableName}")
    public String createTable(@PathVariable String tableName) throws SQLException {
        return patientService.createTable(tableName);
    }
}

