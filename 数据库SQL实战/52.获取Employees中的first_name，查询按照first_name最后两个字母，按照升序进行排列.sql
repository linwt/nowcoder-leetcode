--  substr(X,Y,Z)，X是要截取的字符串，Y是字符串的起始位置(最小为1)，Z是要截取字符串的长度(省略则取到末尾)
select first_name
from employees
order by substr(first_name, length(first_name)-1);


select first_name
from employees
order by substr(first_name, -2);


select first_name
from employees
order by substr(first_name, -2, 2);