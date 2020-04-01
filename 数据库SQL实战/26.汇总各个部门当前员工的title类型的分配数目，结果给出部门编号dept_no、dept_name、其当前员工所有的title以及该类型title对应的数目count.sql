-- 三表信息关联，按部门号和头衔分组，统计个数
select dm.dept_no, dm.dept_name, t.title, count(*) as count
from departments as dm, dept_emp as de, titles as t
where dm.dept_no=de.dept_no and de.emp_no=t.emp_no and de.to_date='9999-01-01' and t.to_date='9999-01-01'
group by dm.dept_no, t.title;