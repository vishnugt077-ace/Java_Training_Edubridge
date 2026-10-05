Q1. Create a Table with Constraints
Query
CREATE TABLE fees (
    fee_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    amount INT NOT NULL CHECK (amount > 0),
    paid_on DATE,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

INSERT INTO fees (student_id, amount, paid_on)
VALUES
(1, 15000, '2026-06-05'),
(2, 12000, '2026-06-07'),
(1, 8000, '2026-07-01');

SELECT * FROM fees;
Output
+--------+------------+--------+------------+
| fee_id | student_id | amount | paid_on    |
+--------+------------+--------+------------+
| 1      | 1          | 15000  | 2026-06-05 |
| 2      | 2          | 12000  | 2026-06-07 |
| 3      | 1          | 8000   | 2026-07-01 |
+--------+------------+--------+------------+

Q2. Filter and Sort
Query
SELECT name, city, age
FROM students
WHERE age > 20
AND city <> 'Hyderabad'
ORDER BY age DESC;
Output
+---------------+-----------+-----+
| name          | city      | age |
+---------------+-----------+-----+
| Priya Nair    | Chennai   | 23  |
| Sneha Iyer    | Bengaluru | 22  |
| Vikram Singh  | Delhi     | 21  |
+---------------+-----------+-----+

Q3. Pattern Matching with LIKE and IN
Query
SELECT name, city
FROM students
WHERE name LIKE 'A%'
OR city IN ('Chennai', 'Delhi')
ORDER BY name;
Output
+---------------+-----------+
| name          | city      |
+---------------+-----------+
| Aarav Sharma  | Hyderabad |
| Ananya Das    | Chennai   |
| Priya Nair    | Chennai   |
| Vikram Singh  | Delhi     |
+---------------+-----------+

Q4. Students per City
Query
SELECT city, COUNT(*) AS total
FROM students
GROUP BY city
ORDER BY total DESC, city;
Output
+-----------+-------+
| city      | total |
+-----------+-------+
| Hyderabad | 3     |
| Bengaluru | 2     |
| Chennai   | 2     |
| Delhi     | 1     |
+-----------+-------+

Q5. Insert and Update
Query
INSERT INTO courses
VALUES (106, 'Cloud Basics', 9000, 5);

UPDATE courses
SET fee = fee + 500
WHERE weeks <= 6;

SELECT * FROM courses
ORDER BY fee;
Output
+-----------+-----------------+-------+-------+
| course_id | title           | fee   | weeks |
+-----------+-----------------+-------+-------+
| 102       | SQL & MySQL     | 8500  | 4     |
| 106       | Cloud Basics    | 9500  | 5     |
| 105       | Data Structures | 10500 | 6     |
| 103       | Python          | 12500 | 6     |
| 101       | Core Java       | 15000 | 8     |
| 104       | Web Development | 18000 | 10    |
+-----------+-----------------+-------+-------+

Q6. Course Statistics with HAVING
Query
SELECT course_id,
       COUNT(marks) AS marked,
       ROUND(AVG(marks), 1) AS avg_marks,
       MAX(marks) AS highest,
       MIN(marks) AS lowest
FROM enrollments
GROUP BY course_id
HAVING COUNT(marks) >= 2
ORDER BY course_id;
Output
+-----------+--------+-----------+---------+--------+
| course_id | marked | avg_marks | highest | lowest |
+-----------+--------+-----------+---------+--------+
| 101       | 4      | 76.3      | 88      | 58     |
| 102       | 3      | 76.0      | 92      | 65     |
| 104       | 2      | 72.0      | 95      | 49     |
+-----------+--------+-----------+---------+--------+

Q7. Report with 3-Table JOIN
Query
SELECT s.name, c.title, e.marks
FROM enrollments e
JOIN students s
    ON e.student_id = s.student_id
JOIN courses c
    ON e.course_id = c.course_id
WHERE e.marks IS NOT NULL
ORDER BY e.marks DESC;
Output
+---------------+-----------------+-------+
| name          | title           | marks |
+---------------+-----------------+-------+
| Priya Nair    | Web Development | 95    |
| Aarav Sharma  | SQL & MySQL     | 92    |
| Aarav Sharma  | Core Java       | 88    |
| Rohan Verma   | Core Java       | 83    |
| Diya Patel    | Python          | 81    |
| Diya Patel    | Core Java       | 76    |
| Sneha Iyer    | SQL & MySQL     | 71    |
| Rohan Verma   | SQL & MySQL     | 65    |
| Priya Nair    | Core Java       | 58    |
| Vikram Singh  | Web Development | 49    |
+---------------+-----------------+-------+

Q8. Courses per Student — LEFT JOIN
Query
SELECT s.name,
       COUNT(e.enroll_id) AS courses
FROM students s
LEFT JOIN enrollments e
    ON s.student_id = e.student_id
GROUP BY s.student_id, s.name
ORDER BY courses DESC, s.name;
Output
+---------------+---------+
| name          | courses |
+---------------+---------+
| Aarav Sharma  | 2       |
| Diya Patel    | 2       |
| Priya Nair    | 2       |
| Rohan Verma   | 2       |
| Karthik Reddy | 1       |
| Sneha Iyer    | 1       |
| Vikram Singh  | 1       |
| Ananya Das    | 0       |
+---------------+---------+

Q9. Above-Average Scorers
Query
SELECT DISTINCT s.name
FROM students s
JOIN enrollments e
    ON s.student_id = e.student_id
WHERE e.marks > (
    SELECT AVG(marks)
    FROM enrollments
)
ORDER BY s.name;
The overall average is 75.8.
Output
+---------------+
| name          |
+---------------+
| Aarav Sharma  |
| Diya Patel    |
| Priya Nair    |
| Rohan Verma   |
+---------------+

Q10. Grade Report with CASE
Query
SELECT s.name,
       c.title,
       e.marks,
       CASE
           WHEN e.marks IS NULL THEN 'Pending'
           WHEN e.marks >= 85 THEN 'A'
           WHEN e.marks >= 70 THEN 'B'
           WHEN e.marks >= 50 THEN 'C'
           ELSE 'Fail'
       END AS grade
FROM enrollments e
JOIN students s
    ON e.student_id = s.student_id
JOIN courses c
    ON e.course_id = c.course_id
WHERE e.course_id IN (101, 103)
ORDER BY c.course_id, e.marks DESC;
Output
+---------------+-----------+-------+---------+
| name          | title     | marks | grade   |
+---------------+-----------+-------+---------+
| Aarav Sharma  | Core Java | 88    | A       |
| Rohan Verma   | Core Java | 83    | B       |
| Diya Patel    | Core Java | 76    | B       |
| Priya Nair    | Core Java | 58    | C       |
| Diya Patel    | Python    | 81    | B       |
| Karthik Reddy | Python    | NULL  | Pending |
+---------------+-----------+-------+---------+
