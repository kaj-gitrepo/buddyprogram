/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: AdminController.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 21, 2024
 * Last Modified: Aug 21, 2024
 * Description:
 *     The AdminController class is part of the BuddyProgram application's
 *     web layer and is responsible for handling all web requests related to
 *     Admin requests. 
 *      
 *     It provides endpoints for the frontend or external
 *     clients to manage employee data effectively as part of the broader
 *     BuddyProgram functionalities.
 *
 *     Key endpoints include:
 *     - GET /v1/admin/buddylist: Retrieve all buddy associates who are mentor
 *     (TBD) - POST /api/employees: Add a new employee 
 *     (TBD) - PUT /api/employees/{id}: Update an existing employee
 *     (TBD) - DELETE /api/employees/{id}: Delete an employee
 */
package com.ust.ticl.buddyprogram.controller;

import com.ust.ticl.buddyprogram.dto.EmployeeDTO;
import com.ust.ticl.buddyprogram.model.Employee;
import com.ust.ticl.buddyprogram.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.util.List;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {
    
    /* @Autowired
    private EmployeeService employeeService;
 */
    private final EmployeeService employeeService;
    

    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);    

    @GetMapping("/senior-buddies")
    public ResponseEntity<List<Employee>> getAllSeniorBuddies() {
        List<Employee> seniorBuddies = employeeService.findEmployeesByRole("senior-buddy");
        return ResponseEntity.ok(seniorBuddies);
    }

    @GetMapping("/junior-buddies")
    public ResponseEntity<List<Employee>> getAllJuniorBuddies() {
        List<Employee> juniorBuddies = employeeService.findEmployeesByRole("junior-buddy");
        return ResponseEntity.ok(juniorBuddies);
    }

    @PutMapping(value = "/senior-buddies/{employeeId}", consumes = "application/json")
    public ResponseEntity<EmployeeDTO> upsertSeniorBuddy(@PathVariable String employeeId, @RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeId(employeeId); // Ensure ID is set from path
        EmployeeDTO updatedEmployeeDTO = employeeService.upsertSeniorBuddy(employeeDTO);
        logger.info("Upsert Senior buddy Response: {}", updatedEmployeeDTO.toString());
        return ResponseEntity.ok(updatedEmployeeDTO);
    }

    /* @GetMapping("/buddy-program")
    public ResponseEntity<List<ProgramReportDTO>> getProgramReport() {
        List<ProgramReportDTO> report = buddyReportService.generateProgramReport();
        return ResponseEntity.ok(report);
    } */
}