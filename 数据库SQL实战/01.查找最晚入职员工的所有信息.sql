-- 入职日期等于最大入职日期
select *
from employees
where hire_date = (select max(hire_date) from employees);


-- 按照入职日期降序排序，取第一条
select *
from employees
order by hire_date desc
limit 1;