-- 按照员工号分组并统计次数
select emp_no, count(*)
from salaries
group by emp_no
having count(*)>15;


-- having在产生虚表后执行
-- 查询字段使用替代名
select emp_no, count(emp_no) as times
from salaries
group by emp_no
having times > 15;


-- 此处对员工和薪水去重
select emp_no, count(emp_no) as times
from (select distinct emp_no, salary from salaries)
group by emp_no
having times > 15;