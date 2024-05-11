-- 测试查询功能
create table stus(
	id int primary key auto_increment,
	name varchar(55) not null,
	sex char(1) check(sex='f' or sex='m'),
	leader int,
	hireDate date not null,
	sallary int check(sallary>=0 and sallary<100000),
	bonus int,
	deptno int unique
)
-- 查询整个表，用*号
select * from stus
-- 只查询某列
select sex,name from stus
-- 查询时计算出新列，表不会添加该列
select id,name,sallary,sallary/30,sallary*12 from stus
select name,sallary,bonus,sallary+bonus from stus
select name,id,id%100 from stus
-- 查询时新列改列头名
select name,sallary as 'sal',sallary+bonus as water,sallary*12 as 'money' from stus

-- 去重查询
select distinct hireDate from stus
-- 多列去重查询，同时重复时才去除
select distinct hireDate,name from stus

-- 按照某列排序显示，会显示整个表，从小到大排列，表不会重排
select * from stus order by sallary
-- 从大到小排列
select * from stus order by sallary desc
-- 如果相同，按照后面列的排序
select * from stus order by bonus desc,hireDate desc