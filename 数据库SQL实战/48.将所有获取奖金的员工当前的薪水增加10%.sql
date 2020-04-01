update salaries
set salary=salary*1.1
where to_date='9999-01-01' and
    emp_no in (select emp_no from emp_bonus);