-- 查询条件加入计算
select *
from employees
where emp_no%2!=0 and last_name!='Mary'
order by hire_date desc;