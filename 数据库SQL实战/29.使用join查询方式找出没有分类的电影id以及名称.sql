-- 左连接，没有关联到信息说明没有分类
select f.film_id, f.title
from film as f left join film_category as fc
on f.film_id=fc.film_id
where fc.category_id is null;