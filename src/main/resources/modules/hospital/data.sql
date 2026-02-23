-- INSERT INTO patient (name, gender, birth_date, email, blood_group)
-- SELECT 'Peter Parker', 'MALE', '1990-05-10', 'peter.parker@gmail.com', 'A_NEGATIVE'
-- WHERE NOT EXISTS (
--     SELECT 1 FROM patient WHERE email = 'peter.parker@gmail.com'
-- );

-- INSERT INTO patient (name, gender, birth_date, email, blood_group)
-- SELECT 'Harry Osborn', 'MALE', '1991-03-07', 'harry.osborn@gmail.com', 'A_POSITIVE'
-- WHERE NOT EXISTS (
--     SELECT 1 FROM patient WHERE email = 'harry.osborn@gmail.com'
-- );

-- INSERT INTO patient (name, gender, birth_date, email, blood_group)
-- SELECT 'Marry Jane', 'FEMALE', '1993-09-22', 'marry.jane@gmail.com', 'B_NEGATIVE'
-- WHERE NOT EXISTS (
--     SELECT 1 FROM patient WHERE email = 'marry.jane@gmail.com'
-- );



-- INSERT INTO insurance (created_at, policy_number, provider, valid_until)



-- -- SELECT NOW(), 'POL-1001', 'HDFC Ergo', '2025-08-15'
-- -- WHERE NOT EXISTS (
-- --     SELECT 1 FROM insurance WHERE policy_number = 'POL-1001'
-- -- );

-- SELECT NOW(), 'POL-1002', 'Star Health', '2026-12-31'
-- WHERE NOT EXISTS (
--     SELECT 1 FROM insurance WHERE policy_number = 'POL-1002'
-- );

-- -- SELECT NOW(), 'POL-1003', 'ICICI Lombard', '2027-03-20'
-- -- WHERE NOT EXISTS (
-- --     SELECT 1 FROM insurance WHERE policy_number = 'POL-1003'
-- -- );

-- -- SELECT NOW(), 'POL-1004', 'Bajaj Allianz', '2026-06-10'
-- -- WHERE NOT EXISTS (
-- --     SELECT 1 FROM insurance WHERE policy_number = 'POL-1004'
-- -- );

-- -- SELECT NOW(), 'POL-1005', 'Tata AIG', '2025-11-30'
-- -- WHERE NOT EXISTS (
-- --     SELECT 1 FROM insurance WHERE policy_number = 'POL-1005'
-- -- );


-- INSERT INTO doctor (name, email, specialization)
-- SELECT 'Dr. Rathore', 'rathore@gmail.com', 'Cardiology'
-- WHERE NOT EXISTS (
--     SELECT 1 FROM doctor WHERE email = 'rathore@gmail.com'
-- );

-- INSERT INTO doctor (name, email, specialization)
-- SELECT 'Dr. Anderson', 'anderson@gmail.com', 'Neurology'
-- WHERE NOT EXISTS (
--     SELECT 1 FROM doctor WHERE email = 'anderson@gmail.com'
-- );


-- =========================================
-- 1️⃣ INSERT PATIENTS
-- =========================================

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
SELECT 'Mary Jane', 'FEMALE', '1993-09-22', 'mary.jane@gmail.com', 'B_NEGATIVE'
WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE email = 'mary.jane@gmail.com'
);


-- =========================================
-- 2️⃣ INSERT INSURANCE
-- =========================================

INSERT INTO insurance (created_at, policy_number, provider, valid_until)
SELECT NOW(), 'POL-1001', 'HDFC Ergo', '2026-08-15'
WHERE NOT EXISTS (
    SELECT 1 FROM insurance WHERE policy_number = 'POL-1001'
);

INSERT INTO insurance (created_at, policy_number, provider, valid_until)
SELECT NOW(), 'POL-1002', 'Star Health', '2026-12-31'
WHERE NOT EXISTS (
    SELECT 1 FROM insurance WHERE policy_number = 'POL-1002'
);


-- =========================================
-- 3️⃣ LINK INSURANCE TO PATIENT
-- =========================================

UPDATE patient
SET insurance_id = (
    SELECT id FROM insurance WHERE policy_number = 'POL-1001'
)
WHERE email = 'peter.parker@gmail.com';

UPDATE patient
SET insurance_id = (
    SELECT id FROM insurance WHERE policy_number = 'POL-1002'
)
WHERE email = 'harry.osborn@gmail.com';


-- =========================================
-- 4️⃣ INSERT DOCTORS
-- =========================================

INSERT INTO doctor (name, email, specialization)
SELECT 'Dr. Rathore', 'rathore@gmail.com', 'Cardiology'
WHERE NOT EXISTS (
    SELECT 1 FROM doctor WHERE email = 'rathore@gmail.com'
);

INSERT INTO doctor (name, email, specialization)
SELECT 'Dr. Anderson', 'anderson@gmail.com', 'Neurology'
WHERE NOT EXISTS (
    SELECT 1 FROM doctor WHERE email = 'anderson@gmail.com'
);


-- =========================================
-- 5️⃣ INSERT APPOINTMENTS
-- =========================================

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
SELECT '2026-03-01 12:30:00', 'Heart Checkup',
       (SELECT id FROM patient WHERE email='peter.parker@gmail.com'),
       (SELECT id FROM doctor WHERE email='rathore@gmail.com')
WHERE NOT EXISTS (
    SELECT 1 FROM appointment 
    WHERE appointment_time='2026-03-01 12:30:00'
      AND patient_id = (SELECT id FROM patient WHERE email='peter.parker@gmail.com')
);

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
SELECT '2026-03-05 10:00:00', 'Migraine Issue',
       (SELECT id FROM patient WHERE email='harry.osborn@gmail.com'),
       (SELECT id FROM doctor WHERE email='anderson@gmail.com')
WHERE NOT EXISTS (
    SELECT 1 FROM appointment 
    WHERE appointment_time='2026-03-05 10:00:00'
      AND patient_id = (SELECT id FROM patient WHERE email='harry.osborn@gmail.com')
);

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
SELECT '2026-03-10 14:00:00', 'General Consultation',
       (SELECT id FROM patient WHERE email='mary.jane@gmail.com'),
       (SELECT id FROM doctor WHERE email='rathore@gmail.com')
WHERE NOT EXISTS (
    SELECT 1 FROM appointment 
    WHERE appointment_time='2026-03-10 14:00:00'
      AND patient_id = (SELECT id FROM patient WHERE email='mary.jane@gmail.com')
);