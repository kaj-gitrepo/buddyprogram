/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: EmployeeRepository.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 8, 2024
  * Description:
 *     The EmployeeRepository interface extends JpaRepository, providing
 *     essential CRUD operations and the ability to define custom queries for
 *     managing Employee entities. It acts as the primary data access mechanism
 *     for Employee data, facilitating easy integration with the database layer
 *     for the BuddyProgram application.
 */
package com.ust.ticl.buddyprogram.repository;

import com.ust.ticl.buddyprogram.model.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findAll();
    List<Employee> findByRole(String role);
    Optional<Employee> findByEmployeeId(String employeeId);
    Employee findByEmployeeIdAndRoleIgnoreCase(String employeeId, String role);
}
