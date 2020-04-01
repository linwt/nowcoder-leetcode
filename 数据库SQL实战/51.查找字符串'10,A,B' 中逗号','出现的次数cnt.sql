-- length()计算字符串长度，replace()替换字符串
select (length('10,A,B') - length(replace('10,A,B', ',', ''))) as cnt;


select 2 as cnt;