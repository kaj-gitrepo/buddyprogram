/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: ReportServiceRepository.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 27, 2024
 * Last Modified: Aug 27, 2024
  * Description:
 *     
 */
package com.ust.ticl.buddyprogram.repository;

import com.ust.ticl.buddyprogram.model.BuddyProgram;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportServiceRepository extends JpaRepository<BuddyProgram, Long> {

    List<BuddyProgram> findAll();
}
