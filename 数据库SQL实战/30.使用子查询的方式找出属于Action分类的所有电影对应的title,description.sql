-- 表信息关联获取符合条件的film_id，再根据这个条件去获取其他信息
select title, description
from film
where film_id in
(select fc.film_id
from category as c, film_category as fc
where c.name='Action' and c.category_id=fc.category_id)