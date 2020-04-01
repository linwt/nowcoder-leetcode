-- 按薪水分组用于去重，取第二多
select emp_no, salary
from salaries
group by salary
order by salary desc
limit 1,1;


-- 子查询直接对薪水去重，取第二多的薪水，父查询再获取要查询的信息
select emp_no, salary
from salaries
where salary=(
    select distinct salary from salaries
    order by salary desc
    limit 1,1
);