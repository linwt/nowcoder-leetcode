-- 根据条件获得虚表，实表与虚表进行多表关联获取信息
select c.name, count(fc.film_id)
from film as f, film_category as fc, category as c,
    (select category_id, count(film_id) as num
    from film_category
    group by category_id
    having num>=5) as cn
where f.description like '%robot%'
    and f.film_id=fc.film_id
    and fc.category_id=c.category_id
    and c.category_id=cn.category_id;