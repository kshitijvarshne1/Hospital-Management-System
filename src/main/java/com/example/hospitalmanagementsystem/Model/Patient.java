/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 27-Apr-21
 *   Time: 5:07 PM
 *   File: Patient.java
 */

package com.example.hospitalmanagementsystem.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {
    private int id;
    private String patientName;
    private int allocatedRoomNo;
    private int allocatedDoctorName;
    private String dateOfAdmit;

    public Patient(int id, String patientName, int allocatedRoomNo, int allocatedDoctorName, String dateOfAdmit) {
        this.id = id;
        this.patientName = patientName;
        this.allocatedRoomNo = allocatedRoomNo;
        this.allocatedDoctorName = allocatedDoctorName;
        this.dateOfAdmit = dateOfAdmit;
    }

}

