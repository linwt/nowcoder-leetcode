-- 先按员工号分组并选出最小id，再删除非这些id的数据
delete from titles_test
where id not in
(select min(id) from titles_test group by emp_no);