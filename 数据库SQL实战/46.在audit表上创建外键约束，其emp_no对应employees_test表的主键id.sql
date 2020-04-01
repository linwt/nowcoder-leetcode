-- mysql
alter table audit
add foreign key(emp_no) references employees_test(id);


-- sqlite
drop table audit;
create table audit(
    emp_no int not null,
    create_date datetime not null,
    foreign key(emp_no) references employees_test(id)
);


drop table audit;
create table audit(
    emp_no int not null references employees_test(id),
    create_date datetime not null
);