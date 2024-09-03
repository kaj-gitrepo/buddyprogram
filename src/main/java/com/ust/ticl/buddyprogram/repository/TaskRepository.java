/*
 * Copyright (C) 2024 TICL, UST.
 *
 * File: SkillsetRepository.java
 * Author: Abdul Jabbar Karpoor
 * UST ID : 184228
 * Email: abdul.jabbarkarpoor@ust.com
 * Created: Aug 8, 2024
 * Last Modified: Aug 8, 2024
 * Description:
 *     The SkillsetRepository interface extends JpaRepository, offering customized
 *     CRUD operations and query methods for managing the Skillset entities in the
 *     BuddyProgram application. It facilitates the manipulation and retrieval of skill
 *     data essential for matching employees in mentorship roles based on their
 *     expertise and career development goals. This repository helps in aligning the
 *     employees’ skills with the appropriate mentors or mentees, enhancing the
 *     effectiveness of the mentorship program.
 */
package com.ust.ticl.buddyprogram.repository;

import com.ust.ticl.buddyprogram.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

