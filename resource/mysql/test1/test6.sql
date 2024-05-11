-- 复制表，数据+结构，主外键不会复制
create table student6
as
select * from student5

-- 复制表，只有结构
create table student7
as
select * from student5 where 1=2

-- 复制表，部分结构+结构
create table student8
as
select sno,sex from student5

-- 复制表，只有部分结构
create table student9
as
select sno,sname from student5 where 9=8