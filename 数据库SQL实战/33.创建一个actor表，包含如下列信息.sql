-- sqlite
create table actor (
    actor_id smallint(5) not null primary key,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    last_update timestamp not null default (datetime('now','localtime'))
);


create table actor (
    actor_id smallint(5) not null,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    last_update timestamp not null default (datetime('now','localtime')),
    primary key(actor_id)
);


-- mysql
create table actor (
    actor_id smallint(5) not null,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    last_update timestamp not null default current_timestamp,
    primary key(actor_id)
);