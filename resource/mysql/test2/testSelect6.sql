-- 几种常用的函数，max最大值，min最小值，sum求和，avg求平均值，count条目总数
select max(sallary),min(sallary),sum(sallary),avg(sallary),count(sallary) from stus
-- count（）中填什么都行，但填1效率高
select count(*) from stus
select count(1) from stus
-- 去重查询条数的方法
select count(distinct sex) from stus
-- sum和avg会忽略null，avg的除数也会忽略null
select sum(bonus),avg(bonus) from stus