create table if not exists user_1(
id serial primary key ,
first_name varchar(30) not null,
last_name varchar(30) not null ,
username varchar(20) unique ,
password varchar(20) not null
);


create table if not exists task(
id serial primary key ,
id_user int ,
content varchar(255) ,
status varchar(255),
doing_time timestamp

)