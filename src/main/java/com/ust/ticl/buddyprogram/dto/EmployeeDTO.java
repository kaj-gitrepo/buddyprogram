
/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: EmployeeDTO.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 22, 2024
 * Last Modified: Aug 22, 2024
 * Description:
 *     The EmployeeDTO class abstraction for an employee entity in the BuddyProgram system. 
 *     This provide more control over the fields that can be exposed to API clients.
 */
package com.ust.ticl.buddyprogram.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private String employeeId;
    private String name;
    private String email;
    private String contact;
    private String location;
    private String band;
    private String role;

    // for Getters and Setters lombok is used
}
