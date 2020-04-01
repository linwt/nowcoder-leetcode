-- limit X,Y    X表示起始序号(最小为0)，Y表示返回记录数
select *
from employees
limit 5,5;


select *
from employees
limit (2-1)*5,5


-- limit M offset N     N表示起始序号(最小为0)，M表示返回记录数
select *
from employees
limit 5 offset 5;