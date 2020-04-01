create view actor_name_view as
select first_name as first_name_v, last_name as last_name_v from actor;


create view actor_name_view (first_name_v, last_name_v) as
select first_name, last_name from actor;