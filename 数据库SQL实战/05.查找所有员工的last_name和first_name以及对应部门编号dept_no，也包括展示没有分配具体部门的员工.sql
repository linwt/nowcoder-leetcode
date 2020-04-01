-- 员工可能未分配部门，故使用左连接
select e.last_name, e.first_name, d.dept_no
from employees as e left join dept_emp as d
on e.emp_no=d.emp_no;