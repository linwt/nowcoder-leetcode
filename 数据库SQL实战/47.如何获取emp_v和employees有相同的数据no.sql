select e.*
from employees as e, emp_v as v
where e.emp_no=v.emp_no;


-- 交集
select * from employees
intersect
select * from emp_v;