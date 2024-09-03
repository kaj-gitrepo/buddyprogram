/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: Buddy.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 8, 2024
 * Description:
 *     The Buddy entity represents the buddy relationship within the BuddyProgram.
 *     This class is part of the domain model and is mapped to the 'buddy' table
 *     in the database. It includes details about the mentor-mentee pairing,
 *     referencing the Employee entity for both mentor and mentee details.
 */
package com.ust.ticl.buddyprogram.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "buddy_program")
public class BuddyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Long programId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "senior_buddy_id", referencedColumnName = "employee_id")
    private Employee seniorBuddy;

    @ManyToOne
    @JoinColumn(name = "junior_buddy_id", referencedColumnName = "employee_id")
    private Employee juniorBuddy;

    @Column(name = "program_startDate")
    private Date programStartDate;

    @Column(name = "primary_technology")
    private String primaryTechnology;

    @Column(name = "category")
    private String category;

    @Column(name = "project_allocation_status")
    private String projectAllocationStatus;

    // Getters and Setters
    
}

