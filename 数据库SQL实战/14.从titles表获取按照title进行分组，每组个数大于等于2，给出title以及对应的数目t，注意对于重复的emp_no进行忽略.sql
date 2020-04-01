-- 员工号去重
select title, count(distinct emp_no) as t
from titles
group by title
having t>=2;


select title, count(title) as t
from (select distinct * from titles)
group by title
having t>=2;