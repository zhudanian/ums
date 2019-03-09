drop database if exists ums;
create database ums;

use ums;
create table t_user(

	id int primary key auto_increment,
	username varchar(50) not null unique,
	password varchar(32),
	age int
	

)engine=innodb charset=utf8;