-- Drop the existing EMPLOYEE table
DROP TABLE IF EXISTS EMPLOYEE;

-- Create the EMPLOYEE table with the updated schema
CREATE TABLE EMPLOYEE (
    employee_id VARCHAR(50) PRIMARY KEY,  -- Unique identifier for each employee
    name VARCHAR(255) NOT NULL,           -- Employee's full name
    email VARCHAR(255) UNIQUE NOT NULL,   -- Employee's email address
    contact VARCHAR(50),                  -- Employee's contact number
    location VARCHAR(255),                -- Employee's location
    band VARCHAR(10)                      -- Band with no predefined values
);
-- Insert sample data into EMPLOYEE
INSERT INTO EMPLOYEE (employee_id, name, email, contact, location, band) VALUES
('100001', 'Aarav Kumar', 'aarav.kumar@ust.com', '9876543210', 'Bangalore', 'A1'),
('100002', 'Vivaan Sharma', 'vivaan.sharma@ust.com', '9123456789', 'Trivandrum', 'B2'),
('100003', 'Arjun Patel', 'arjun.patel@ust.com', '9345678901', 'Chennai', 'C1'),
('100004', 'Vivaan Iyer', 'vivaan.iyer@ust.com', '9988776655', 'Bangalore', 'A2'),
('100005', 'Ishaan Reddy', 'ishaan.reddy@ust.com', '9900112233', 'Trivandrum', 'B1'),
('100006', 'Rohan Menon', 'rohan.menon@ust.com', '9911223344', 'Chennai', 'C2');

CREATE TABLE BUDDY_PROGRAM (
    program_id SERIAL PRIMARY KEY,        -- Unique identifier for each buddy program
    senior_buddy_id VARCHAR(50) NOT NULL, -- Employee ID of the senior buddy
    junior_buddy_id VARCHAR(50) NOT NULL, -- Employee ID of the junior buddy
    program_startDate DATE,               -- Start date of the buddy program
    primary_technology VARCHAR(255),      -- Primary technology used in the program
    category VARCHAR(255),                -- Category of the buddy program
    project_allocation_status VARCHAR(50), -- Status of project allocation
    FOREIGN KEY (senior_buddy_id) REFERENCES EMPLOYEE(employee_id) ON DELETE CASCADE,
    FOREIGN KEY (junior_buddy_id) REFERENCES EMPLOYEE(employee_id) ON DELETE CASCADE
);

CREATE TABLE PROGRAM_FEEDBACK (
    feedback_id SERIAL PRIMARY KEY,        -- Unique identifier for feedback
    program_id INT NOT NULL,               -- Reference to the buddy program
    feedback_by_senior TEXT,              -- Feedback from the senior buddy about the program
    feedback_by_junior TEXT,              -- Feedback from the junior buddy about the program
    FOREIGN KEY (program_id) REFERENCES BUDDY_PROGRAM(program_id) ON DELETE CASCADE
);

CREATE TABLE TASK (
    task_id SERIAL PRIMARY KEY,           -- Unique identifier for each task
    program_id INT NOT NULL,              -- Reference to the buddy program
    task_name VARCHAR(255),               -- Name of the task
    task_progress VARCHAR(50),            -- Progress status of the task (e.g., Not Started, In Progress, Completed)
    task_startDate DATE,                  -- Start date of the task
    task_endDate DATE,                    -- End date of the task
    task_feedback TEXT,                   -- Feedback on the task provided by the senior buddy
    FOREIGN KEY (program_id) REFERENCES BUDDY_PROGRAM(program_id) ON DELETE CASCADE
);

-- Insert sample data into BUDDY_PROGRAM
INSERT INTO BUDDY_PROGRAM (senior_buddy_id, junior_buddy_id, program_startDate, primary_technology, category, project_allocation_status) VALUES
('100001', '100002', '2024-08-01', 'Java', 'Onboarding', 'Assigned'),
('100001', '100003', '2024-08-15', 'Python', 'Training', 'In Progress'),
('100004', '100005', '2024-09-01', 'C++', 'Mentoring', 'Not Started');

-- Insert sample data into PROGRAM_FEEDBACK
INSERT INTO PROGRAM_FEEDBACK (program_id, feedback_by_senior, feedback_by_junior) VALUES
(1, 'Senior buddy feedback: Great progress', 'Junior buddy feedback: Learning a lot'),
(2, 'Senior buddy feedback: Needs improvement', 'Junior buddy feedback: Good guidance received'),
(3, 'Senior buddy feedback: Awaiting progress', 'Junior buddy feedback: Looking forward to more interaction');

-- Insert sample data into TASK
INSERT INTO TASK (program_id, task_name, task_progress, task_startDate, task_endDate, task_feedback) VALUES
(1, 'Java Streams', 'In Progress', '2024-08-01', '2024-08-15', 'Good start'),
(1, 'Python', 'Not Started', '2024-08-15', '2024-09-01', 'Awaiting completion'),
(2, 'Training on Docker', 'Completed', '2024-08-15', '2024-08-30', 'Well done'),
(3, 'Github', 'Not Started', '2024-09-01', '2024-09-15', 'Pending');