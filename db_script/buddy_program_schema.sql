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

ALTER TABLE EMPLOYEE
ADD COLUMN comments TEXT,
ADD COLUMN modified_by VARCHAR(255),
ADD COLUMN email VARCHAR(255) UNIQUE;

CREATE TABLE SKILLSET (
    skillset_id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL,
    skill_name VARCHAR(255) NOT NULL,
    self_rating INT DEFAULT 0 CHECK (self_rating >= 0 AND self_rating <= 10),
    assessment_result VARCHAR(255),
    assessment_name VARCHAR(255),
    assessment_type VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEE(employee_id) ON DELETE CASCADE
);
CREATE TABLE buddy (
    --buddy_id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL,
    buddy_tag VARCHAR(50) NOT NULL,
    buddy_emp_id INT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEE(employee_id) ON DELETE CASCADE,
    FOREIGN KEY (buddy_emp_id) REFERENCES EMPLOYEE(employee_id) ON DELETE CASCADE,
    CHECK (buddy_tag IN ('mentor', 'mentee'))
);


