-- 使用case when
select e.emp_no, e.first_name, e.last_name, eb.btype, s.salary,
    (case eb.btype
     when 1 then s.salary*0.1
     when 2 then s.salary*0.2
     else s.salary*0.3
     end) as bonus
from employees as e, salaries as s, emp_bonus as eb
where e.emp_no=s.emp_no and e.emp_no=eb.emp_no and s.to_date='9999-01-01';


select e.emp_no, e.first_name, e.last_name, eb.btype, s.salary,
    (case when eb.btype=1 then s.salary*0.1
     when eb.btype=2 then s.salary*0.2
     else s.salary*0.3
     end) as bonus
from employees as e, salaries as s, emp_bonus as eb
where e.emp_no=s.emp_no and e.emp_no=eb.emp_no and s.to_date='9999-01-01';


-- 按照规律可得计算方式
select e.emp_no, e.first_name, e.last_name, eb.btype, s.salary,
    (s.salary * eb.btype / 10.0) as bonus
from employees as e, salaries as s, emp_bonus as eb
where e.emp_no=s.emp_no and e.emp_no=eb.emp_no and s.to_date='9999-01-01';