select e.emp_no, de.dept_no, eb.btype, eb.recevied
from employees as e
inner join dept_emp as de
on e.emp_no=de.emp_no
left join emp_bonus as eb
on de.emp_no=eb.emp_no;


-- 省略employees
select de.emp_no, de.dept_no, eb.btype, eb.recevied
from dept_emp as de
left join emp_bonus as eb
ON de.emp_no=eb.emp_no;