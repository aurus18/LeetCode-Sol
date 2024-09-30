# Write your MySQL query statement below
select e2.employee_id,
       e2.name,
       COUNT(e1.employee_id) as reports_count,
       ROUND(AVG(e1.age)) as average_age
from Employees as e1
join Employees as e2
on e1.reports_to = e2.employee_id
group by employee_id
order by employee_id