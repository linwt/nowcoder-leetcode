-- 以表a当前薪水小于等于表b当前薪水为条件进行内连接，可以关联获得比表a中当前薪水大的记录数，去重统计个数即可得到排名
select a.emp_no, a.salary, count(distinct b.salary) as rank
from salaries as a inner join salaries as b
on a.salary<=b.salary
where a.to_date='9999-01-01' and b.to_date='9999-01-01'
group by a.emp_no
order by a.salary desc, a.emp_no asc;


select a.emp_no, a.salary, count(distinct b.salary) as rank
from salaries as a, salaries as b
where a.salary<=b.salary and a.to_date='9999-01-01' and b.to_date='9999-01-01'
group by a.emp_no
order by a.salary desc, a.emp_no asc;