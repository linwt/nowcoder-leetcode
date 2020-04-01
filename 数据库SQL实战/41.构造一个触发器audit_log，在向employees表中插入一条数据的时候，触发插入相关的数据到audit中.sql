-- 1、用 create trigger 语句构造触发器，用 before 或 after 来指定在执行后面的SQL语句之前或之后来触发 trigger
-- 2、触发器执行的内容写出 begin 与 end 之间
-- 3、可以使用 new 与 old 关键字访问触发后或触发前的 employees_test 表单记录
create trigger audit_log after insert on employees_test
begin
    insert into audit values (new.id, new.name);
end;