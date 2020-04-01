-- 在 sqlite 系统表 sqlite_master 中可以获得所有表的索引
-- 其中字段 name 是所有表的名字，而且对于自己创建的表而言，字段 type 永远是 'table'
select ("select count(*) from " || name || ";") as cnts
from sqlite_master
where type='table';


-- mysql
select concat("select count(*) from ", table_name, ";") as cnts
from (select table_name from information_schema.tables) as new;