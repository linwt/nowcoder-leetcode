-- 入职日期降序排序取第三条
select *
from employees
order by hire_date desc
limit 2,1;