select * from student
alter table student drop scor

-- 增加一行数据
insert into student values(1,"liu","m",19,"2023-10-13","stu","124@163.com",99)
-- 字符串不区分""和''
-- 日期写成"yyyy-MM-dd" or "yyyy/MM/dd" or "yyyy.MM.dd"
insert into student values(2,'liu',"m",19,'2023-10-13','stu',"124@163.com",99)
-- 日期函数 now()，表示当前时间
insert into student values(3,'wei','f',20,now(),'stu','223@qq.com',88)
-- 指定列添加数据
insert into student(sex,name) values('f','lin')
-- 指定行修改数据，会匹配多行
update student set score=66 where name='liu'
update student set age=30,classname='stud' where name='liu' and score=66
update student set age=28 where name='wei' or name='lin'
-- 删除某行
delete from student where name='wei'
-- 删除所有行
delete form student