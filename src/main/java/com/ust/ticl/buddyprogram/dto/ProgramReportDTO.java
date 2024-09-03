package com.ust.ticl.buddyprogram.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProgramReportDTO {
    private int slNumber;
    private String location;
    private String seniorBuddyId;
    private String seniorBuddyName;
    private String juniorBuddyId;
    private String juniorBuddyName;
    private Date startDate;
    private String band;
    private String primaryTechnology;
    private String category;
    private String contactNumber;
    private String projectAllocationStatus;

    //Lombok annotation implemented for getter and setter
}
