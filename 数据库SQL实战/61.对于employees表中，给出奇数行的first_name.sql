-- 表中first_name已经进行升序排列
-- 先计算该行前面有多少行，得到该行的索引位置，再获取奇数行
select e1.first_name
from employees as e1
where (select count(*)
      from employees as e2
      where e1.first_name<=e2.first_name)%2=1;