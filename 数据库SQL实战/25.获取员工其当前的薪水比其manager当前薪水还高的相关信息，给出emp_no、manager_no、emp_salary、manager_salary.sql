-- 建立员工工资表和领导工资表，进行关联和比较
select a.emp_no as emp_no, b.emp_no as manager_no, a.salary as emp_salary, b.salary as manager_salary
from (select s.emp_no, s.salary, de.dept_no
    from dept_emp as de, salaries as s
    where de.emp_no=s.emp_no and s.to_date='9999-01-01')
    as a,
    (select s.emp_no, s.salary, dm.dept_no
    from dept_manager as dm, salaries as s
    where dm.emp_no=s.emp_no and s.to_date='9999-01-01')
    as b
where a.dept_no=b.dept_no and a.salary>b.salary;


-- 四表直接关联信息
select de.emp_no as emp_no, dm.emp_no as manager_no, s1.salary as emp_salary, s2.salary as manager_salary
from dept_emp as de, dept_manager as dm, salaries as s1, salaries as s2
where de.emp_no=s1.emp_no and dm.emp_no=s2.emp_no and de.dept_no=dm.dept_no and
    s1.salary>s2.salary and s1.to_date='9999-01-01' and s2.to_date='9999-01-01';