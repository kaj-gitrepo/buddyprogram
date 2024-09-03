
/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: Employee.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 8, 2024
 * Description:
 *     The Employee entity class models an employee in the BuddyProgram system. 
 *     This class is mapped to the 'employee' table in the database and includes 
 *     personal and professional details relevant to the program such as name, 
 *     designation, and department. It is designed to be flexible to accommodate 
 *     various roles within the company, including participants in mentorship programs.
 *
 *     Employees are linked to the Buddy and Skillset entities. Each employee can have 
 *     multiple skillsets and can participate in multiple mentorship relationships, 
 *     either as a mentor or a mentee. This relationship is crucial for matching employees 
 *     in the buddy system based on compatible skills and mentorship needs.
 */
package com.ust.ticl.buddyprogram.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;



@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contact")
    private String contact;

    @Column(name = "location")
    private String location;

    @Column(name = "band")
    private String band;

    @Column(name = "role")
    private String role;

    /* // Senior buddy relationship
    @OneToMany(mappedBy = "seniorBuddy")
    private List<Employee> juniorBuddies;

    // Junior buddy relationship
    @ManyToOne
    @JoinColumn(name = "senior_buddy_id")
    private Employee seniorBuddy; */

}
