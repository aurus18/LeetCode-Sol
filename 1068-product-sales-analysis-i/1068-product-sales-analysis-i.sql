# Write your MySQL query statement below
SELECT p.product_name, s.year, s.price
from Product as p
inner join Sales as s
on p.product_id = s.product_id;