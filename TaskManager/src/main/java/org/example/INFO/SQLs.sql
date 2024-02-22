CREATE TABLE projects (
    project_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255),
    description TEXT,
    start_date DATE,
    end_date DATE
);

INSERT INTO projects (project_name, description, start_date, end_date)
VALUES
    ('Project A', 'Description for Project A', '2024-01-01', '2024-12-31'),
    ('Project B', 'Description for Project B', '2024-02-15', '2024-11-30'),
    ('Project C', 'Description for Project C', '2024-03-10', '2024-10-15');


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

INSERT INTO tasks (task_name, description, status, priority, created_date, due_date, project_id)
VALUES
    ('Task 1', 'Description for Task 1', 'In Progress', 'High', '2024-01-10', '2024-02-28', 1),
    ('Task 2', 'Description for Task 2', 'Open', 'Medium', '2024-02-20', '2024-04-15', 1),
    ('Task 3', 'Description for Task 3', 'Completed', 'Low', '2024-03-15', '2024-03-31', 2);


CREATE TABLE task_reports (
    report_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_id BIGINT,
    completion_date DATE,
    description TEXT,
    FOREIGN KEY (task_id) REFERENCES tasks(task_id)
);

INSERT INTO task_reports (task_id, completion_date, description)
VALUES
    (1, '2024-02-28', 'Task 1 completed successfully'),
    (2, '2024-04-15', 'Task 2 completed with minor issues'),
    (3, '2024-03-31', 'Task 3 completed ahead of schedule');
