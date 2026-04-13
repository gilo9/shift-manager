-- Users
INSERT INTO EMPLOYEES (employee_id, last_name, first_name, Email, Password) VALUES
                                                                           (1, 'Alice',   'Nguyen',   'alice.nguyen@shifts.com',   X'70617373776f726431'),
                                                                           (2, 'Ben',     'Okafor',   'ben.okafor@shifts.com',     X'70617373776f726432'),
                                                                           (3, 'Carla',   'Reyes',    'carla.reyes@shifts.com',    X'70617373776f726433'),
                                                                           (4, 'Dan',     'Mitchell', 'dan.mitchell@shifts.com',   X'70617373776f726434');

-- Shifts
INSERT INTO SHIFTS (shift_id, SHIFT_NAME, SHIFT_DATE, EMPLOYEE_ID, RATE, HOURS, total_Pay) VALUES
                                                                                             (1,  'Morning Open',    '2025-04-07', 1, 12.50, 8.0,  100.00),
                                                                                             (2,  'Afternoon Cover', '2025-04-07', 2, 13.00, 6.0,   78.00),
                                                                                             (3,  'Evening Close',   '2025-04-07', 3, 12.50, 7.5,   93.75),
                                                                                             (4,  'Morning Open',    '2025-04-08', 4, 12.50, 8.0,  100.00),
                                                                                             (5,  'Split Shift',     '2025-04-08', 1, 13.00, 5.0,   65.00),
                                                                                             (6,  'Evening Close',   '2025-04-08', 2, 12.50, 7.5,   93.75),
                                                                                             (7,  'Morning Open',    '2025-04-09', 3, 13.50, 8.0,  108.00),
                                                                                             (8,  'Afternoon Cover', '2025-04-09', 4, 12.50, 6.5,   81.25);

