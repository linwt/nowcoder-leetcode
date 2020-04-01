-- 窗口函数
select emp_no, salary, (sum(salary) over(order by emp_no)) as running_total
from salaries
where to_date='9999-01-01';


-- 由于内连接后按照a.emp_no分组，且b.emp_no<=a.emp_no，所以一行a.emp_no关联前面所有员工的b.emp_no
-- 所以sum(b.salary)为当前员工前面所有员工的salary累计
select a.emp_no, a.salary, sum(b.salary) as running_total
from salaries as a, salaries as b
where b.emp_no<=a.emp_no and a.to_date = '9999-01-01' and b.to_date = '9999-01-01'
group by a.emp_no
order by a.emp_no;


select a.emp_no, a.salary,
    (select sum(b.salary)
     from salaries b
     where b.to_date='9999-01-01'
     and b.emp_no<=a.emp_no) as running_total
from salaries as a
where a.to_date='9999-01-01'
order by a.emp_no;