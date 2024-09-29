# Write your MySQL query statement below
-- SELECT b.name
-- FROM Employee as a
-- INNER JOIN Employee as b
-- ON a.managerId = b.id
-- GROUP BY b.managerID
-- HAVING COUNT(b.id) > 4;

SELECT a.name
FROM Employee as a
WHERE a.id IN (
    SELECT b.managerId
    FROM Employee as b
    GROUP BY b.managerId
    HAVING COUNT(b.id) >= 5
)