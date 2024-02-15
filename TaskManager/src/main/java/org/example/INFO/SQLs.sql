CREATE TABLE projects (
    project_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255),
    description TEXT,
    start_date DATE,
    end_date DATE
);

CREATE TABLE tasks (
    task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(255),
    description TEXT,
    status VARCHAR(50),
    priority VARCHAR(50),
    created_date DATE,
    due_date DATE,
    project_id BIGINT,
    FOREIGN KEY (project_id) REFERENCES projects(project_id)
);

CREATE TABLE task_reports (
    report_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_id BIGINT,
    completion_date DATE,
    description TEXT,
    FOREIGN KEY (task_id) REFERENCES tasks(task_id)
);
