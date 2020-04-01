-- 两次内连接关联表信息，按照部门号分组，用count()函数统计个数
select dm.dept_no, dm.dept_name, count(s.salary) as sum
from salaries as s
inner join dept_emp as de
on s.emp_no=de.emp_no
inner join departments as dm
on de.dept_no=dm.dept_no
group by dm.dept_no;


-- 内连接可以转化为where查询
select dm.dept_no, dm.dept_name, count(s.salary) as sum
from salaries as s, dept_emp as de, departments as dm
where s.emp_no=de.emp_no and de.dept_no=dm.dept_no
group by dm.dept_no;