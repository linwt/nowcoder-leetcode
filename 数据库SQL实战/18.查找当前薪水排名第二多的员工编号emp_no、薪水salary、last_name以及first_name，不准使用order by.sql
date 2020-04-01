-- 在薪水小于第一多的数据中获取最多，即为第二多
select e.emp_no, max(s.salary) as salary, e.last_name, e.first_name
from employees as e, salaries as s
where s.salary < (select max(salary) from salaries)
    and e.emp_no=s.emp_no and s.to_date='9999-01-01';