-- 语句的执行顺序，from-where-groupby-having-orderby
select avg(sallary) from stus
select sex,avg(sallary) from stus group by sex
select sex,sum(sallary) from stus group by sex having sum(sallary)>10000
select sex,sum(sallary) from stus where sallary<1000 group by sex having sum(sallary)>100
select sex,sum(sallary) from stus where sallary<10000 group by sex having sum(sallary)>100 order by sum(sallary) desc