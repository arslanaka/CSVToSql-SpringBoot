package com.aka.batchUploading.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empID;
    private String firstName;
    private String lastName;
    private String startDate;
    private String exitDate;
    private String title;
    private String supervisor;
    private String email;
    private String businessUnit;
    private String employeeStatus;
    private String employeeType;
    private String payZone;
    private String employeeClassificationType;
    private String terminationType;
    private String terminationDescription;
    private String departmentType;
    private String division;
    private String dob;
    private String state;
    private String jobFunctionDescription;
    private String genderCode;
    private String locationCode;
    private String raceDesc;
    private String maritalDesc;
    private String performanceScore;
    private String currentEmployeeRating;

    public Employee(String firstName, String lastName, String startDate, String exitDate, String title, String supervisor,
                    String email, String businessUnit, String employeeStatus, String employeeType, String payZone,
                    String employeeClassificationType, String terminationType, String terminationDescription, String departmentType,
                    String division, String dob, String state, String jobFunctionDescription, String genderCode, String locationCode,
                    String raceDesc, String maritalDesc, String performanceScore, String currentEmployeeRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.exitDate = exitDate;
        this.title = title;
        this.supervisor = supervisor;
        this.email = email;
        this.businessUnit = businessUnit;
        this.employeeStatus = employeeStatus;
        this.employeeType = employeeType;
        this.payZone = payZone;
        this.employeeClassificationType = employeeClassificationType;
        this.terminationType = terminationType;
        this.terminationDescription = terminationDescription;
        this.departmentType = departmentType;
        this.division = division;
        this.dob = dob;
        this.state = state;
        this.jobFunctionDescription = jobFunctionDescription;
        this.genderCode = genderCode;
        this.locationCode = locationCode;
        this.raceDesc = raceDesc;
        this.maritalDesc = maritalDesc;
        this.performanceScore = performanceScore;
        this.currentEmployeeRating = currentEmployeeRating;
    }
}
