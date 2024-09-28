-- Insert three users with password : student123 faculty123 admin123 repectively 
-- INSERT INTO "users" (id, username, password, role, name, email, phone)
-- VALUES 
-- (1, 'student1', '$2a$12$cZdzVQPb7x3CEq8hw5aJxOEqxjpaZs8NnBVDP7OC0qFaT4WRElEKq', 'STUDENT', 'John Doe', 'john.student@example.com', '1234567890'),
-- (2, 'faculty1', '$2a$12$2oirOAXbmCYtMF84Ixl4H.dt7XFw8JPc8N.9eXqs4ou3Mgpkp81AK', 'FACULTY_MEMBER', 'Dr. Jane Smith', 'jane.faculty@example.com', '2345678901'),
-- (3, 'admin1', '$2a$12$rWJ9sMePg/XBKOhQhEC9l.9ZCTpQ37Bk2EzlUX6pZTq0k6olmyviy', 'ADMINISTRATOR', 'Mark Admin', 'mark.admin@example.com', '3456789012');


-- Insert student profile
-- INSERT INTO studentprofile (user_id, photo, department_id, year)
-- VALUES (1, 'path/to/photo1.jpg', 1, '2024');


-- Insert faculty profile
-- INSERT INTO facultyprofile (user_id, photo, department_id, office_hours)
-- VALUES (2, 'path/to/photo2.jpg', 2, 'Mon-Sat 9 AM - 4 PM');


-- Insert admin profile
-- INSERT INTO administratorprofile (user_id, photo, department_id)
-- VALUES (3, 'path/to/photo3.jpg', 3);
