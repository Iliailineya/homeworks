CREATE TABLE task_reports (
    report_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_id BIGINT,
    completion_date DATE,
    description TEXT,
    FOREIGN KEY (task_id) REFERENCES tasks(task_id)
);
