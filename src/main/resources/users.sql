create table if not exists USERS(id identity primary key,name VARCHAR(255) not null);
truncate table USERS;
insert into USERS (name) values ('ahmed');
insert into USERS (name) values ('elhdad');