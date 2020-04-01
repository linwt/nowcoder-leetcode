-- 内连接关联表信息，按照title分组，用avg()函数计算平均工资
select title, avg(salary) as avg
from titles as t inner join salaries as s
on s.emp_no=t.emp_no
where s.to_date='9999-01-01' and t.to_date='9999-01-01'
group by title;


select title, avg(salary) as avg
from salaries as s, titles as t
where s.emp_no=t.emp_no and s.to_date='9999-01-01' and t.to_date='9999-01-01'
group by title;