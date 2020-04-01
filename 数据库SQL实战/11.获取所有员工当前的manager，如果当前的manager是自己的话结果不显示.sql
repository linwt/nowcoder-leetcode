-- 内连接关联信息
select e.emp_no, m.emp_no
from dept_emp as e inner join dept_manager as m
on e.dept_no=m.dept_no
where e.emp_no!=m.emp_no and e.to_date='9999-01-01' and m.to_date='9999-01-01';


-- 不等于号使用 “！=” 或 “<>”
-- 内连接条件可以转化为where条件
select e.emp_no, m.emp_no
from dept_emp as e, dept_manager as m
where e.dept_no=m.dept_no and e.emp_no<>m.emp_no and e.to_date='9999-01-01' and m.to_date='9999-01-01';