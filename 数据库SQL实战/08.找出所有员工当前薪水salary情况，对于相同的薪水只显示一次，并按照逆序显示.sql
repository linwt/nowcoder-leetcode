-- 对某字段去重可用distinct或group by
select distinct salary
from salaries
where to_date='9999-01-01'
order by salary desc;


select salary
from salaries
where to_date='9999-01-01'
group by salary
order by salary desc;