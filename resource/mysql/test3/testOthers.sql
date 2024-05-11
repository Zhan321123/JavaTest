-- 相关子查询
-- 查询每个部门工资最高的人的信息
select name,sallary,hiredate from stus s1 where sallary in (select max(sallary) from stus s2 where s1.hiredate=s2.hiredate)