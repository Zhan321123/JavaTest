-- 选中代码后运行
-- mysql的基本语句

-- 新建表
CREATE TABLE student (
  -- 类型type（数字），表示类型和限制
	-- int（n），int类型，n无意义
	sno INT ( 3 ),
	-- varchar（n），String类型，不定字数字符串，输入字符数量限制0-n
	NAME VARCHAR ( 55 ),
	-- char（n），String类型，定字数字符串，输入字符数量限制0-n，最后一定会变成n个
	sex CHAR ( 2 ),
	age INT,
	dtdate date,
	classname VARCHAR ( 55 ),
	email VARCHAR ( 55 ) 
) 

-- 查询表中的数据
SELECT * FROM student
-- 查询表结构信息，相当于Java中的类信息
desc student
-- 查询建立表的完整SQL语句
show create table student

-- 在表中新增一列
-- double（n，m），double类型，表示共有n个数字，小数点后有m个数字
alter table student add score double(3,1)
-- 在表中最前面新增一列
alter table student add score2 double(4,1) first
-- 在某个列后面新增一列,没有之前
alter table student add score3 double(2,1) after age

-- 修改某个列的类型type
alter table student modify score3 int
-- 修改某列的列头的名，也可以修改类型
alter table student change score3 scor double(4,2)

-- 删除某列
alter table student drop score2
-- 删除表
drop table student

-- 给表重命名
alter table student rename stu