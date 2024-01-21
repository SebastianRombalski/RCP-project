DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS section;


CREATE TABLE sections
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    description    VARCHAR(50)  NOT NULL,
    shift          INT NOT NULL
);

CREATE TABLE employees
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    login_code    VARCHAR(100) NOT NULL UNIQUE,
    section_id       BIGINT NOT NULL ,
    FOREIGN KEY (section_id) REFERENCES sections(id)
);

CREATE TABLE managers
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    login         VARCHAR(100) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL
);

CREATE TABLE manager_sections
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    manager_id BIGINT NOT NULL,
    section_id BIGINT NOT NULL,
    FOREIGN KEY (manager_id) REFERENCES managers(id),
    FOREIGN KEY (section_id) REFERENCES sections(id)
);

CREATE TABLE events_in_progress
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_start     DATETIME NOT NULL,
    employee_id   BIGINT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);


CREATE TABLE events
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_start    DATETIME NOT NULL,
    date_stop     DATETIME NOT NULL ,
    employee_id  BIGINT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees(id)

);