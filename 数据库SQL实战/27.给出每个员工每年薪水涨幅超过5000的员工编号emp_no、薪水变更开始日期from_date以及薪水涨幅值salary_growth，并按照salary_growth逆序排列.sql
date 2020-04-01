-- 复用表，关联涨薪日期相差一年的信息，薪水作差计算涨薪幅度
select a.emp_no, a.from_date, (a.salary-b.salary) as salary_growth
from salaries as a, salaries as b
where a.emp_no=b.emp_no and strftime('%Y', a.to_date)-strftime('%Y', b.to_date)=1 and salary_growth>5000
order by salary_growth desc;