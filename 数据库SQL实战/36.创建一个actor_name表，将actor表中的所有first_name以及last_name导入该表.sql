-- sqlite，建表时插入数据
create table actor_name as
select first_name, last_name from actor;


-- mysql，as可省略也可保留
create table actor_name
select first_name, last_name from actor;


-- 先建表再插入数据
create table actor_name (
    first_name varchar(45) not null,
    last_name varchar(45) not null
);
insert into actor_name
select first_name, last_name from actor;