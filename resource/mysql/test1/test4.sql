create table student3(
	sno int auto_increment,
	name varchar(55) not null,
	sex char(1) default 'm',
	age int,
	score double(4,1) not null,
	dtdate date not null,
	classname varchar(55) not null,
	email varchar(55),
	
	-- 添加约束的第二种方法
	constraint pk_student3_sno primary key(sno),
	constraint ck_student3_age check(age>=0 and age<=130),
	constraint ck_student3_sex check(sex='m' or sex='f'),
	constraint uk_student3_email unique(email)
)

-- 创建表之后的约束方法
alter table student3 add constraint pk_student_sno primary key(son)
alter table student3 modify sno int auto_increment

--删除表的约束
alter table student3 drop primary key