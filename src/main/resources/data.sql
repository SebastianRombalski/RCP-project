
INSERT INTO
    sections (description, shift)
VALUES
    ('Enginering', 1),
    ('Enginering', 2),
    ('Test_and_packing',1),
    ('Test_and_packing',2);

INSERT INTO
    employees (first_name, last_name, login_code,status, section_id)
VALUES
    ('Jan', 'Kowalski', '231241231','active', 1),
    ('Patrycja', 'Nowak', '231223141231','inactive',1),
    ('Stefan', 'Jakis', '231241532231','inactive',3);



INSERT INTO
    events_in_progress (date_start, employee_id)
VALUES
    ('2021-12-01 14:30:15', 2),
    ('2021-12-01 14:30:15', 1);

INSERT INTO
    events (date_start, date_stop, employee_id)
VALUES
    ('2021-01-01 10:30:15','2021-01-01 14:50:15', 1),
    ('2021-01-03 14:30:15','2021-01-03 14:50:15', 1),
    ('2021-01-01 14:30:15','2021-01-02 14:50:15', 1),
    ('2021-12-01 14:30:15','2021-12-01 14:50:15', 3),
    ('2021-12-05 14:30:15','2021-12-01 14:50:15', 3),
    ('2021-12-06 14:30:15','2021-12-01 14:50:15', 3);


INSERT INTO
    managers (first_name, last_name, login, password)
VALUES
    ('andrzej', 'jakis', 'andrzej.jakis', 'fsafsada');

INSERT INTO
    manager_sections (manager_id, section_id)
VALUES
       (1,1),
       (1,2),
       (1,3);
