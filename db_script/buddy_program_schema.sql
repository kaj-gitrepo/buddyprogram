CREATE TABLE EMPLOYEE (
    employee_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    designation VARCHAR(50),
    grade VARCHAR(10),
    tp_status VARCHAR(20),
    project_status VARCHAR(20),
    tp_startDate DATE,
    tp_endDate DATE,
    modified_date TIMESTAMP,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE SKILLSET (
    skillset_id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL,
    skill_name VARCHAR(100) NOT NULL,
    self_rating VARCHAR(20),
    assessment_result VARCHAR(100),
    assessment_name VARCHAR(100),
    assessment_type VARCHAR(50),
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEE(employee_id) ON DELETE CASCADE,
    UNIQUE (employee_id, skill_name) -- Ensures an employee can only have one record per skill
);
CREATE TABLE buddy (
    buddy_id SERIAL PRIMARY KEY,
employee_id INT NOT NULL,
    buddy_tag VARCHAR(50) NOT NULL,
    buddy_emp_id INT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEE(employee_id) ON DELETE CASCADE,
    FOREIGN KEY (buddy_emp_id) REFERENCES EMPLOYEE(employee_id) ON DELETE CASCADE,
    CHECK (buddy_tag IN ('mentor', 'mentee'))
);


