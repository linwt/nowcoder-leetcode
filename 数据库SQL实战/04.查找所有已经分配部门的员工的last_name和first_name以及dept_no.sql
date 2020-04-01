-- 已分配表示部门员工表和员工表对应的员工信息共同存在，故使用内连接
-- 查询的字段在两表中唯一故可省略表名
select last_name, first_name, dept_no
from dept_emp as d inner join employees as e
on e.emp_no=d.emp_no;


-- 按照查询条件关联两表信息，相当于内连接
select e.last_name, e.first_name, d.dept_no
from employees as e, dept_emp as d
where e.emp_no=d.emp_no;