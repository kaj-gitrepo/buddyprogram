/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: BuddyprogramApplication.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 9, 2024
 * Description:
 *     This class serves as the entry point for the BuddyProgram application.
 *     It initializes the Spring Boot application context and configures the
 *     entire application's startup behavior. 
 *
 *     This application is designed to manage buddy pairings in an organization
 *     to facilitate mentorship programs. It handles the registration of
 *     participants, matching buddies based on skills and preferences, and
 *     providing tools for ongoing management and tracking of the mentorship
 *     relationships.
 */


package com.ust.ticl.buddyprogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuddyprogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuddyprogramApplication.class, args);
	}

}
