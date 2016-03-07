# --- !Ups

create table songs (
     id serial,
     name varchar(255) not null,
     votes long,
     dateInsert timestamp default current_timestamp,
     primary key (id)
);

# --- !Downs


drop table if exists songs;