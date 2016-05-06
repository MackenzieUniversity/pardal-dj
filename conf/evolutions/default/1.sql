# --- !Ups

create table songs (
     id serial,
     name varchar(255) not null,
     author varchar(255),
     votes bigint DEFAULT 0,
     dateInsert timestamp default current_timestamp,
     primary key (id)
);

insert into songs(name,author) values ('We are the champions', 'Queen');
insert into songs(name,author) values ('A Dama e o Vagabundo', 'Wesley Safadão');
insert into songs(name,author) values ('Dark Necessities', 'Red Hot Chilli Peppers');
insert into songs(name,author) values ('Let it go', 'Demi Lovato');
insert into songs(name,author) values ('Decode', 'Paramore');
insert into songs(name,author) values ('Hero', 'Jessie J');
insert into songs(name,author) values ('Purple Rain', 'Prince');



# --- !Downs


drop table if exists songs;