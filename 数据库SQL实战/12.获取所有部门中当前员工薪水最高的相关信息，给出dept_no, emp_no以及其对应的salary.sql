-- 内连接关联信息，按照部门分组，max()函数获取每个部门的最高薪水
select d.dept_no, d.emp_no, max(s.salary) as salary
from dept_emp as d inner join salaries as s
on d.emp_no=s.emp_no
where d.to_date='9999-01-01' and s.to_date='9999-01-01'
group by d.dept_no;


select d.dept_no, d.emp_no, max(s.salary) as salary
from dept_emp as d, salaries as s
where d.emp_no=s.emp_no and d.to_date='9999-01-01' and s.to_date='9999-01-01'
group by d.dept_no;