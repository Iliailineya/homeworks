CREATE TABLE projects (
    project_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255),
    description TEXT,
    start_date DATE,
    end_date DATE
);
