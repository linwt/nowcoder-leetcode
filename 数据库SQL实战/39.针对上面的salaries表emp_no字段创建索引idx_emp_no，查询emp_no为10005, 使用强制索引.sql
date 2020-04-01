-- sqlite
select *
from salaries
indexed by idx_emp_no
where emp_no=10005;


-- mysql
select *
from salaries
force index idx_emp_no
where emp_no=10005;