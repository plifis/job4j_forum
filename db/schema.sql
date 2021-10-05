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

CREATE TABLE authorities (
                             id serial primary key,
                             authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users (
                       id serial primary key,
                       username VARCHAR(50) NOT NULL unique,
                       email varchar (200),
                       password VARCHAR(100) NOT NULL,
                       enabled boolean default true,
                       authority_id int not null references authorities(id)
);

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');