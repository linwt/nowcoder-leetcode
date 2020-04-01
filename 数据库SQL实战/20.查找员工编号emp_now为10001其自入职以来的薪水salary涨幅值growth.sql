-- 直接取最大和最小工资作差，但存在最后一次工资是降薪的情况
select (max(salary)-min(salary)) as growth
from salaries
where emp_no=10001;


-- 按照日期排序，取最大和最小日期对应的工资作差
select (
    (select salary from salaries where emp_no=10001 order by to_date desc limit 1) -
    (select salary from salaries where emp_no=10001 order by to_date asc limit 1)
) as growth;