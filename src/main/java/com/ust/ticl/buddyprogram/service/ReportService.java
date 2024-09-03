package com.ust.ticl.buddyprogram.service;


import com.ust.ticl.buddyprogram.dto.ProgramReportDTO;
import java.util.List;


public interface ReportService {

    List<ProgramReportDTO> generateBuddyReport();
    
}
