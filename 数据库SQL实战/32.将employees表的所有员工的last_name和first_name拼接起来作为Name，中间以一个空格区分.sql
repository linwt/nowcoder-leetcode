-- sqlite
select last_name || ' ' || first_name as name
from employees;


-- mysql
select concat(last_name, ' ', first_name) as name
from employees;