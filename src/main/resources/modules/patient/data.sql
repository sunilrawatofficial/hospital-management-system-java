INSERT INTO patient (name, gender, birth_date, email, blood_group)
SELECT 'Peter Parker', 'MALE', '1990-05-10', 'peter.parker@gmail.com', 'A_NEGATIVE'
WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE email = 'peter.parker@gmail.com'
);

INSERT INTO patient (name, gender, birth_date, email, blood_group)
SELECT 'Harry Osborn', 'MALE', '1991-03-07', 'harry.osborn@gmail.com', 'A_POSITIVE'
WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE email = 'harry.osborn@gmail.com'
);

INSERT INTO patient (name, gender, birth_date, email, blood_group)
SELECT 'Marry Jane', 'FEMALE', '1993-09-22', 'marry.jane@gmail.com', 'B_NEGATIVE'
WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE email = 'marry.jane@gmail.com'
);
