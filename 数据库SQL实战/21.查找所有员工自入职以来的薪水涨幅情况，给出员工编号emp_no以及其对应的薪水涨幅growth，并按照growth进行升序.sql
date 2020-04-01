-- 员工表两次内连接薪水表，关联获取当前和入职时的薪水，作差得到涨幅
select e.emp_no, (a.salary-b.salary) as growth
from employees as e
inner join salaries as a
on e.emp_no=a.emp_no and a.to_date='9999-01-01'
inner join salaries as b
on e.emp_no=b.emp_no and b.from_date=e.hire_date
order by growth asc;


-- 建立两张表，当前和入职时的薪水表，再关联信息作差得到涨幅
select a.emp_no, (a.salary-b.salary) as growth
from (select s.emp_no, s.salary from employees as e, salaries as s where e.emp_no=s.emp_no and s.to_date='9999-01-01') as a,
(select s.emp_no, s.salary from  employees as e, salaries as s where e.emp_no=s.emp_no and s.from_date=e.hire_date) as b
where a.emp_no=b.emp_no
order by growth asc;