-- 表的约束
-- 创建表时的约束
create table student2(
  -- primary key 主键
	-- auto_increatment 自增
	-- not null 非空
	-- default value默认值
	-- check(Key=value) 检查
	-- unique 唯一
	sno int primary key auto_increment,
	name varchar(55) not null,
	sex char(1) default 'm' check(sex='m' or sex='f'),
	age int check(age>=0 and age<=130),
	score double(3,1) not null,
	dtdate date not null,
	classname varchar(55) not null,
	email varchar(55) unique
)

desc student2
select * from student2

insert into student2 values(default,'gao','m',30,99,'2023-10-14','java-1','1234@qq')