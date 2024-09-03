/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: Skillset.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 8, 2024
 * Description:
 *     The Skillset entity class represents the various skills each employee in the
 *     BuddyProgram possesses. It is linked to the Employee entity and is used to
 *     match mentors and mentees based on skill compatibility. This class is mapped
 *     to the 'skillset' table in the database.
 *
 *     Each Skillset record contains details about a specific skill, including the
 *     skill name, self-assessment rating by the employee, and potentially assessment
 *     results from formal evaluations. This information is crucial for the effective
 *     matching of buddies in the mentorship program and for tracking skill development
 *     over time.
 */
package com.ust.ticl.buddyprogram.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Getter;
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
@Table(name = "program_feedback")
public class ProgramFeedback implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackId;

    @Column(name = "program_id", nullable = false)
    private Integer programId;

    @Column(name = "feedback_by_senior", columnDefinition = "TEXT")
    private String feedbackBySenior;

    @Column(name = "feedback_by_junior", columnDefinition = "TEXT")
    private String feedbackByJunior;

    // Assuming there is an Entity class called BuddyProgram
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", insertable = false, updatable = false)
    private BuddyProgram buddyProgram;

    // For Getters and Setters lombok is used
}
