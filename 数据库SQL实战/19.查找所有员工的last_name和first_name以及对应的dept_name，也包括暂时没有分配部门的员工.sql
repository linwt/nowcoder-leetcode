-- 两次左连接关联表信息
select e.last_name, e.first_name, dm.dept_name
from (employees as e left join dept_emp as de on e.emp_no=de.emp_no)
      left join departments as dm on de.dept_no=dm.dept_no;


select e.last_name, e.first_name, dm.dept_name
from employees as e left join
    (dept_emp as de left join departments as dm on de.dept_no=dm.dept_no)
on e.emp_no=de.emp_no;


select e.last_name, e.first_name, d.dept_name
from employees as e left join
    (select de.emp_no, dm.dept_name
    from dept_emp as de, departments as dm
    where de.dept_no=dm.dept_no) as d
on e.emp_no=d.emp_no;