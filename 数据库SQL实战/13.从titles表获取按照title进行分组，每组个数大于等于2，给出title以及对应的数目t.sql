-- 按title分组，用count()函数统计个数
select title, count(title) as t
from titles
group by title
having t>=2;