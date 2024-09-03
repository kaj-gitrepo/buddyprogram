package com.ust.ticl.buddyprogram.service;

import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ust.ticl.buddyprogram.dto.ProgramReportDTO;
import com.ust.ticl.buddyprogram.model.BuddyProgram;
import com.ust.ticl.buddyprogram.model.Employee;
import com.ust.ticl.buddyprogram.repository.EmployeeRepository;
import com.ust.ticl.buddyprogram.repository.ReportServiceRepository;

@Service
public class ReportServiceImpl implements ReportService {
    
    private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class); 

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReportServiceRepository reportServiceRepository;

    @Override
    @Transactional
    public List<ProgramReportDTO> generateBuddyReport() {
        logger.info("return buddy program report");
        List<ProgramReportDTO> reportList = new ArrayList<>();
        List<BuddyProgram> buddyPrograms = reportServiceRepository.findAll();

        int slNumber = 1;
        for (BuddyProgram program : buddyPrograms) {
            ProgramReportDTO dto = new ProgramReportDTO();
            dto.setSlNumber(slNumber++);
            dto.setPrimaryTechnology(program.getPrimaryTechnology());
            dto.setCategory(program.getCategory());
            dto.setStartDate(program.getProgramStartDate());

            // Fetch Senior Buddy details
            Employee empObj = program.getSeniorBuddy();
            Employee seniorBuddy = employeeRepository.findByEmployeeIdAndRoleIgnoreCase(program.getSeniorBuddy().getEmployeeId(), "senior-buddy");
            if (seniorBuddy != null) {
                dto.setSeniorBuddyId(seniorBuddy.getEmployeeId());
                dto.setSeniorBuddyName(seniorBuddy.getName());
                dto.setLocation(seniorBuddy.getLocation());
                dto.setBand(seniorBuddy.getBand());
                dto.setContactNumber(seniorBuddy.getContact());
            } else {
                dto.setSeniorBuddyId(null);
                dto.setSeniorBuddyName(null);
            }

            // Fetch Junior Buddy details
            Employee juniorBuddy = employeeRepository.findById(program.getJuniorBuddy().getEmployeeId()).orElse(null);
            if (juniorBuddy != null) {
                dto.setJuniorBuddyId(juniorBuddy.getEmployeeId());
                dto.setJuniorBuddyName(juniorBuddy.getName());
            } else {
                dto.setJuniorBuddyId(null);
                dto.setJuniorBuddyName(null);
            }

            // Set project allocation status
            dto.setProjectAllocationStatus(program.getProjectAllocationStatus());

            // Add dto to report list
            reportList.add(dto);
        }

        return reportList;
    }

    
    
}
