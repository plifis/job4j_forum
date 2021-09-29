create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                        comment_id int references comments(id),
                       created timestamp without time zone not null default now()
);
create table comments (
                       id serial primary key,
                       comment varchar(5000),
                       author varchar(100),
                       created timestamp without time zone not null default now()
);
create table users (
                       id serial primary key,
                       name varchar(2000),
                       email varchar(2000),
                       password varchar (50)
);