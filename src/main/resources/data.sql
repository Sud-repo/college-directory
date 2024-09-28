-- Insert users with passwords: student123, faculty123, admin123 respectively
INSERT INTO `users` (`id`, `username`, `password`, `role`, `name`, `email`, `phone`)
VALUES 
    -- Students
    (1, 'student1', '$2a$12$cZdzVQPb7x3CEq8hw5aJxOEqxjpaZs8NnBVDP7OC0qFaT4WRElEKq', 'STUDENT', 'John Doe', 'john.student@example.com', '1234567890'),
    (4, 'student2', '$2a$12$cZdzVQPb7x3CEq8hw5aJxOEqxjpaZs8NnBVDP7OC0qFaT4WRElEKq', 'STUDENT', 'Alice Green', 'alice.student@example.com', '1234567891'),
    (5, 'student3', '$2a$12$cZdzVQPb7x3CEq8hw5aJxOEqxjpaZs8NnBVDP7OC0qFaT4WRElEKq', 'STUDENT', 'Bob White', 'bob.student@example.com', '1234567892'),
    (6, 'student4', '$2a$12$cZdzVQPb7x3CEq8hw5aJxOEqxjpaZs8NnBVDP7OC0qFaT4WRElEKq', 'STUDENT', 'Clara Black', 'clara.student@example.com', '1234567893'),

    -- Faculty Members
    (2, 'faculty1', '$2a$12$2oirOAXbmCYtMF84Ixl4H.dt7XFw8JPc8N.9eXqs4ou3Mgpkp81AK', 'FACULTY_MEMBER', 'Dr. Jane Smith', 'jane.faculty@example.com', '2345678901'),
    (7, 'faculty2', '$2a$12$2oirOAXbmCYtMF84Ixl4H.dt7XFw8JPc8N.9eXqs4ou3Mgpkp81AK', 'FACULTY_MEMBER', 'Dr. Tom Hanks', 'tom.faculty@example.com', '2345678902'),
    (8, 'faculty3', '$2a$12$2oirOAXbmCYtMF84Ixl4H.dt7XFw8JPc8N.9eXqs4ou3Mgpkp81AK', 'FACULTY_MEMBER', 'Dr. Sarah Lee', 'sarah.faculty@example.com', '2345678903'),
    (9, 'faculty4', '$2a$12$2oirOAXbmCYtMF84Ixl4H.dt7XFw8JPc8N.9eXqs4ou3Mgpkp81AK', 'FACULTY_MEMBER', 'Dr. Robert Brown', 'robert.faculty@example.com', '2345678904'),

    -- Administrators
    (3, 'admin1', '$2a$12$rWJ9sMePg/XBKOhQhEC9l.9ZCTpQ37Bk2EzlUX6pZTq0k6olmyviy', 'ADMINISTRATOR', 'Mark Admin', 'mark.admin@example.com', '3456789012'),
    (10, 'admin2', '$2a$12$rWJ9sMePg/XBKOhQhEC9l.9ZCTpQ37Bk2EzlUX6pZTq0k6olmyviy', 'ADMINISTRATOR', 'Lucy Admin', 'lucy.admin@example.com', '3456789013'),
    (11, 'admin3', '$2a$12$rWJ9sMePg/XBKOhQhEC9l.9ZCTpQ37Bk2EzlUX6pZTq0k6olmyviy', 'ADMINISTRATOR', 'Jack Admin', 'jack.admin@example.com', '3456789014'),
    (12, 'admin4', '$2a$12$rWJ9sMePg/XBKOhQhEC9l.9ZCTpQ37Bk2EzlUX6pZTq0k6olmyviy', 'ADMINISTRATOR', 'Emma Admin', 'emma.admin@example.com', '3456789015');

-- Insert student profiles
INSERT INTO `studentprofile` (`user_id`, `photo`, `department_id`, `year`)
VALUES
    (1, 'path/to/photo1.jpg', 1, '2024'),
    (4, 'path/to/photo4.jpg', 2, '2024'),
    (5, 'path/to/photo5.jpg', 3, '2023'),
    (6, 'path/to/photo6.jpg', 4, '2023');

-- Insert faculty profiles
INSERT INTO `facultyprofile` (`user_id`, `photo`, `department_id`, `office_hours`)
VALUES
    (2, 'path/to/photo2.jpg', 1, 'Mon-Sat 9 AM - 4 PM'),
    (7, 'path/to/photo7.jpg', 2, 'Mon-Fri 10 AM - 3 PM'),
    (8, 'path/to/photo8.jpg', 3, 'Mon-Sat 8 AM - 12 PM'),
    (9, 'path/to/photo9.jpg', 4, 'Tue-Fri 9 AM - 5 PM');

-- Insert administrator profiles
INSERT INTO `administratorprofile` (`user_id`, `photo`, `department_id`)
VALUES
    (3, 'path/to/photo3.jpg', 1),
    (10, 'path/to/photo10.jpg', 2),
    (11, 'path/to/photo11.jpg', 3),
    (12, 'path/to/photo12.jpg', 4);

    
-- Insert some data into Department
INSERT INTO `department` (`name`, `description`) VALUES 
('Computer Science', 'Department of Computer Science'),
('Mathematics', 'Department of Mathematics'),
('Physics', 'Department of Physics'),
('Chemistry', 'Department of Chemistry');
    