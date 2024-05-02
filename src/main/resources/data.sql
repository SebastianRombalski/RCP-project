INSERT INTO
    roles (role_name)
VALUES
    ('Manager'),
    ('Admin');


INSERT INTO
    sections (description, shift)
VALUES
    ('Enginering', 1),
    ('Enginering2', 2),
    ('Test_and_packing',1),
    ('Test_and_packing2',2),
    ('Quality_control',1);

INSERT INTO
    employees (first_name, last_name, login_code,status, section_id)
VALUES
    ('John', 'Pit', '231241231','active', 1),
    ('Andrew', 'Deep', '231223141231','active',2),
    ('Brad', 'Pit', '231241231321','inactive', 3),
    ('Caroline', 'Kowalski', '23122314123121321','active',4),
    ('Anna', 'Peterson', '2312412314421','active', 5),
    ('Andrew', 'Deep', '23122314123112111','active',3),
    ('Stefan', 'Kowalski', '2312415322314421','active',1);



INSERT INTO
    events_in_progress (date_start, employee_id)
VALUES
    ('2021-12-01 14:30:15', 2),
    ('2021-12-01 14:30:15', 1);

INSERT INTO
    events (date_start, date_stop, employee_id)
VALUES
    ('2024-01-01 10:30:15','2024-01-01 18:50:15', 1),
    ('2024-01-02 14:30:15','2024-01-02 18:50:15', 1),
    ('2024-01-03 14:30:15','2024-01-03 18:50:15', 1),
    ('2024-01-01 14:30:15','2024-1-01 18:50:15', 3),
    ('2024-01-02 14:30:15','2024-1-02 15:50:15', 3),
    ('2024-01-03 14:30:15','2024-1-03 18:50:15', 3);


INSERT INTO
    managers (first_name, last_name, login, password, role_id)
VALUES
    ('manager', 'everyone', 'manager.everyone', '{argon2}$argon2id$v=19$m=16384,t=2,p=1$uMu4j4YAowy6bVKBWg6brw$Bnu4ezKcuionMo5JjG2CvyYISh/A7FQyOW/nu98oUL0', 1),
    ('manager', 'test', 'manager.test', '{argon2}$argon2id$v=19$m=16384,t=2,p=1$uMu4j4YAowy6bVKBWg6brw$Bnu4ezKcuionMo5JjG2CvyYISh/A7FQyOW/nu98oUL0', 1),
    ('manager', 'engineering', 'manager.engineering', '{argon2}$argon2id$v=19$m=16384,t=2,p=1$uMu4j4YAowy6bVKBWg6brw$Bnu4ezKcuionMo5JjG2CvyYISh/A7FQyOW/nu98oUL0', 1);


INSERT INTO
    manager_sections (manager_id, section_id)
VALUES
       (1,1),
       (1,2),
       (1,3),
       (2,3),
       (2,4),
       (3,1),
       (3,2);
