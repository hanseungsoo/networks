create table user(
    user_id varchar(50) primary key,
    password varchar(50) not null,
    user_name varchar(50),
    user_email varchar(50),
    user_addr varchar(50) ,
    user_birth varchar(50),
    enabled boolean not null
);

create table role (
    role_id int auto_increment primary key,
    role_name varchar(50) not null
);

create table user_role(
	user_id varchar(50) not null,
    role_id int not null,
    constraint fk_user_id foreign key(user_id) references user(user_id),
    constraint fk_role_id foreign key(role_id) references role(role_id)
);

insert into role (role_name) values('ADMIN');
insert into role (role_name) values('USER');

commit;