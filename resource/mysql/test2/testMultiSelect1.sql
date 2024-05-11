create table study(
	hiredate date,
	name varchar(55),
	presentation varchar(200),
	number int
)
-- 多表查询
-- cross join加入表方式，就是表相乘
select * from stus cross join study
-- natural join匹配相同的列头
select * from stus natural join study
-- using 指定列头进行匹配
select * from study join stus using(hiredate)

-- on匹配不同名字的列头的方式
select * from study join stus on study.name=stus.name
select * from study s1 join stus s2 on s1.name=s2.name