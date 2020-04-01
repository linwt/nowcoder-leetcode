-- 直接条件查询员工号不在manager中
select emp_no
from employees
where emp_no not in
(select emp_no from dept_manager);


-- 使用左连接，非manager的员工关联不到其他信息，没有dept_no
select e.emp_no
from employees as e left join dept_manager as d
on e.emp_no=d.emp_no
where d.dept_no is null;