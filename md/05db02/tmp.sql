
mysql> create database day12 charset utf8;
Query OK, 1 row affected (0.00 sec)

mysql> use day12;
Database changed

// 创建一个  员工表 emp，  部门表，  dept


create table emp (
	id int primary key auto_increment,
	name char(10) not null,
	salary double 
);


create table dept (
	id int primary key auto_increment,
	name char(20) not null
);

insert into dept values(null,'研发部');
insert into dept values(null,'销售部');
insert into dept values(null,'人事部');
insert into dept values(null,'扯淡部');
insert into dept values(null,'牛宝宝部');

insert into emp values(null,'班长',10000);
insert into emp values(null,'美美',10000);


insert into emp values(null,'班长',10000,1);
insert into emp values(null,'美美',10000,2);
insert into emp values(null,'小凤',10000,3);
insert into emp values(null,'如花',10000,2);
insert into emp values(null,'芙蓉',10000,1);
insert into emp values(null,'东东',800,null);
insert into emp values(null,'波波',1000,null);


create table emp2 (
	id int primary key auto_increment,
	name char(10) not null,
	salary double,
	dept_id int,
	constraint aaa foreign key emp2(dept_id) references dept(id)
);

create table emp3 (
	id int primary key auto_increment,
	name char(10) not null,
	salary double,
	dept_id int,
	foreign key emp3(dept_id) references dept(id)
);

create table user (
	id int primary key auto_increment,
	username varchar(20) not null ,
	password varchar(40),
	nickname varchar(20),
	email varchar(40)
)