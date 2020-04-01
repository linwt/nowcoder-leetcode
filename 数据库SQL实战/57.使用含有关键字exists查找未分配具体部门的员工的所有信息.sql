-- not exists选出查询语句不成立的记录
-- exists是先从主查询中取得一条数据，再代入到子查询中，执行一次子查询，判断子查询是否能返回结果，主查询有多少条数据，子查询就要执行多少次
select *
from employees as e
where not exists
(select emp_no from dept_emp where emp_no=e.emp_no);


-- in是先执行子查询，得到一个结果集，将结果集代入外层谓词条件执行主查询，子查询只需要执行一次
select *
from employees as e
where emp_no not in
(select emp_no from dept_emp where emp_no=e.emp_no);