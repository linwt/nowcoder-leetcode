-- 两次内连接关联表信息
select de.dept_no, de.emp_no, s.salary
from employees as e inner join dept_emp as de
on e.emp_no=de.emp_no
inner join salaries as s
on e.emp_no=s.emp_no
where s.to_date='9999-01-01' and e.emp_no not in (select emp_no from dept_manager);


select de.dept_no, de.emp_no, s.salary
from employees as e, dept_emp as de, salaries as s
where e.emp_no=s.emp_no and e.emp_no=de.emp_no and s.to_date='9999-01-01' and
    e.emp_no not in (select emp_no from dept_manager);


-- 省略employees
select de.dept_no, de.emp_no, s.salary
from dept_emp as de, salaries as s
where de.emp_no=s.emp_no and s.to_date='9999-01-01' and de.emp_no not in (select emp_no from dept_manager);