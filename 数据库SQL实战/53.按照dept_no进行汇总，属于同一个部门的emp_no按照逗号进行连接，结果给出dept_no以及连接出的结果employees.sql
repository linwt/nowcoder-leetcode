-- group_concat(X,Y)，X是要连接的字段，Y是连接时用的符号，可省略，默认为逗号
select dept_no, group_concat(emp_no) as employees
from dept_emp
group by dept_no;


select dept_no, group_concat(emp_no, ',') as employees
from dept_emp
group by dept_no;