/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: EmployeeController.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 8, 2024
 * Description:
 *     The EmployeeController class is part of the BuddyProgram application's
 *     web layer and is responsible for handling all web requests related to
 *     employee management. 
 *      
 *     It provides endpoints for the frontend or external
 *     clients to manage employee data effectively as part of the broader
 *     BuddyProgram functionalities.
 *
 *     Key endpoints include:
 *     - GET /api/employees: Retrieve all employees
 *     (TBD) - POST /api/employees: Add a new employee 
 *     (TBD) - PUT /api/employees/{id}: Update an existing employee
 *     (TBD) - DELETE /api/employees/{id}: Delete an employee
 */
package com.ust.ticl.buddyprogram.controller;

import com.ust.ticl.buddyprogram.model.Employee;
import com.ust.ticl.buddyprogram.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /* @Autowired
    EmployeeService employeeService; */
    
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

   /*  @GetMapping
    public List<Employee> getEmployeesById() {
        return employeeService.findAllEmployees();
    } */
}
