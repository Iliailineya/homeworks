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
