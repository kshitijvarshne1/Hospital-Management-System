/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Apr-21
 *   Time: 4:48 PM
 *   File: PatientController.java
 */

package com.example.hospitalmanagementsystem.Controller;

import com.example.hospitalmanagementsystem.Model.Patient;
import com.example.hospitalmanagementsystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/createTable/{tableName}")
    public String createTable(@PathVariable String tableName) throws SQLException {
        return patientService.createTable(tableName);
    }

    @PostMapping("/insertPatientInfo")
    public String insertPatientInfo(@RequestBody Patient patient) throws SQLException {
        return patientService.insertPatientInfo(patient);
    }

    @GetMapping("/getAllPatientInfo")
    public List<Patient> getAllPatientInfo() throws SQLException {
        return patientService.getAllPatientInfo();
    }

    @GetMapping("/searchById/{id}")
    public Patient searchById(@PathVariable int id) throws SQLException {
        return patientService.searchById(id);
    }

    @PostMapping("/dischargePatient/{id}")
    public String dischargePatient(@PathVariable int id) throws SQLException {
        return patientService.dischargePatient(id);
    }

}

