-- 内连接的条件可以转化为where条件查询
-- 两表内连接关联获取信息
select s.*, d.dept_no
from salaries as s inner join dept_manager as d
on d.emp_no=s.emp_no
where d.to_date='9999-01-01' and s.to_date='9999-01-01';


-- 按照查询条件关联两表信息，相当于内连接
select s.*, d.dept_no
from salaries as s, dept_manager as d
where d.to_date='9999-01-01' and s.to_date='9999-01-01' and d.emp_no=s.emp_no;