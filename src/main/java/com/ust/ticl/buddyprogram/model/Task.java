/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: Task.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 8, 2024
 * Description:
 *     
 */
package com.ust.ticl.buddyprogram.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "program_id", nullable = false)
    private Integer programId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_progress")
    private String taskProgress;

    @Column(name = "task_startDate")
    @Temporal(TemporalType.DATE)
    private Date taskStartDate;

    @Column(name = "task_endDate")
    @Temporal(TemporalType.DATE)
    private Date taskEndDate;

    @Column(name = "task_feedback", columnDefinition = "TEXT")
    private String taskFeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", insertable = false, updatable = false)
    private BuddyProgram buddyProgram;

    // for Getters and Setters lombok is used
}

