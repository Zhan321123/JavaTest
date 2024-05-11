-- on多表查询的全显示
-- left让左表全部显示，如果匹配不到右表的内容，就全用null显示
select * from stus left join study on stus.hiredate=study.hiredate
-- right让右表全部显示
select * from stus right join study on stus.hiredate=study.hiredate

-- union结合表，将表并集操作，重复的会保留一份
select * from stus left join study on stus.hiredate=study.hiredate
union
select * from stus right join study on stus.hiredate=study.hiredate
-- union all结合表，重复的也加上
select * from stus left join study on stus.hiredate=study.hiredate
union all
select * from stus left join study on stus.hiredate=study.hiredate

-- 多个表查询
select stus.name,sallary,salgrade.grade from stus join study on stus.hiredate=study.hiredate
									 join salgrade on stus.sallary between salgrade.low and salgrade.high