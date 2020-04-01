-- 员工表和薪水表对应的员工信息需要共同存在，故使用内连接
select e.emp_no, s.salary
from employees as e inner join salaries as s
on e.emp_no=s.emp_no and e.hire_date=s.from_date
order by e.emp_no desc;


select e.emp_no, s.salary
from employees as e, salaries as s
where e.emp_no=s.emp_no and e.hire_date=s.from_date
order by e.emp_no desc;