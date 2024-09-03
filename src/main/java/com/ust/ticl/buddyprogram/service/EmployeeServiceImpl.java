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
import com.ust.ticl.buddyprogram.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    /* private final EmployeeRepository employeeRepository; */

    @Autowired
    private EmployeeRepository employeeRepository;
    
    /* public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    } */

   @Autowired
    private ModelMapper modelMapper; 

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findEmployeesByRole(String role) {
        return employeeRepository.findByRole(role);
    }

    public EmployeeDTO upsertSeniorBuddy(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findByEmployeeId(employeeDTO.getEmployeeId())
            .orElse(new Employee()); // Create new if not exists

        // Map DTO to entity
        modelMapper.map(employeeDTO, employee);

        // Ensure only Senior Buddies can be added or updated
        if (!"senior-buddy".equals(employee.getRole())) {
            throw new IllegalArgumentException("Only Senior Buddies can be added or updated.");
        }

        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class); // Convert entity back to DTO
    }
    // Add other methods for business logic

}

