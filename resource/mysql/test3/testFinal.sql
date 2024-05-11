select * from stus
-- 查询姓名重复的学生及其数量，个人信息
select name,count(name) from stus group by name having count(name)>1
select * from stus where name in (select name from stus group by name having count(name)>1)

-- 查询没位学生的成绩是否及格或优秀
create table score(
	name varchar(55),
	chinese int,
	math int,
	english int
)
insert into score values('liu',20,70,100);
insert into score values('gao',80,50,90);
insert into score values('zhan',100,100,99);
insert into score values('wei',10,20,30)

select name,
chinese,
	case 
		when chinese>=80 then 'excellent'
		when chinese>=60 then 'pass'
		else 'fail'
	end as 'chin',
math,
	case
		when math>=80 then 'excellent'
		when math>=60 then 'pass'
		else 'fail'
	end as 'math',
english,
	case 
		when english>=80 then 'execellent'
		when english>=60 then 'pass'
		else 'fail'
	end as 'engl'
from score

-- 查询每天的比赛输赢的数
create table game(
	gameday date,
	result char(1)
)

select gameday,sum(t1.success) s,sum(t1.failed) f,count(1) from (select gameday,if(result='s',1,0) 'success',if(result='f',1,0) 'failed' from game) t1 group by gameday