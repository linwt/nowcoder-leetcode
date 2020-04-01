-- 关联表信息，使用内连接
select d.dept_no, d.emp_no, s.salary
from dept_manager as d inner join salaries as s
on d.emp_no=s.emp_no
where d.to_date='9999-01-01' and s.to_date='9999-01-01';


-- 直接在条件语句中关联表信息
select d.dept_no, d.emp_no, s.salary
from dept_manager as d, salaries as s
where d.emp_no=s.emp_no and d.to_date='9999-01-01' and s.to_date='9999-01-01';