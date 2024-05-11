-- 视图的使用，用于保存查询出来的表格
-- 新建出查询出的视图
create view stuView
as
select name,id,sex from stus
-- 像表格一样查询
select * from stuView
select * from stus

create view stuV
as
select * from stus

select * from stuV
-- 加入视图的东西同样会加入表格
insert into stuV values(9876,'yao','f',1234,'1999-9-9',5000,0,6)
select * from stus
-- 删除视图
drop view stuV