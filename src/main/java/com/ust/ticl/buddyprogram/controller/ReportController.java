package com.ust.ticl.buddyprogram.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ust.ticl.buddyprogram.dto.ProgramReportDTO;
import com.ust.ticl.buddyprogram.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/buddy-report")
    public ResponseEntity<List<ProgramReportDTO>> getBuddyReport() {
        List<ProgramReportDTO> report = reportService.generateBuddyReport();
        return ResponseEntity.ok(report);
    }
}
