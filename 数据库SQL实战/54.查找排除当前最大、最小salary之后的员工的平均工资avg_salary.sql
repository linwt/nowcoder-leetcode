select avg(salary) as avg_salary
from salaries
where to_date='9999-01-01'
    and salary not in (select max(salary) from salaries)
    and salary not in (select min(salary) from salaries);