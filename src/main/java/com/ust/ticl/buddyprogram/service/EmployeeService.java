/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: EmployeeService.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 8, 2024
* Description:
 *     Manages business logic for employee operations within the BuddyProgram.
 *     Facilitates transactional data interactions through EmployeeRepository,
 *     ensuring data integrity and application of business rules across
 *     employee-related actions such as create, update, and delete operations.
 */
package com.ust.ticl.buddyprogram.service;

import com.ust.ticl.buddyprogram.dto.EmployeeDTO;
import com.ust.ticl.buddyprogram.model.Employee;

import java.util.List;

public interface EmployeeService {
    
    List<Employee> findAllEmployees();
    List<Employee> findEmployeesByRole(String role);
    //Employee upsertSeniorBuddy(String employeeId, Employee updateDetails);
    EmployeeDTO upsertSeniorBuddy(EmployeeDTO employeeDTO);
    // Add other methods for business logic
}

