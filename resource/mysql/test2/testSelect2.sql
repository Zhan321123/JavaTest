-- 查询判断，日期也可以判断
-- !=和<>是不等于
select * from stus where name='liu'
select * from stus where sallary>10000
select * from stus where bonus<=300
select * from stus where bonus!=100
select * from stus where bonus<>100
select * from stus where hireDate>'2000-1-1'

-- and和or的使用
select * from stus where sallary>=1000 and sallary<=90000
select * from stus where sallary<=100 or sallary>50000
-- between a and b，在[a,b]区间的值
-- not between a and b，在(-∞,a)|(b,+∞)
select * from stus where sallary between 4000 and 7888
select * from stus where sallary not between 4000 and 7888
-- in（value...），等于一系列值的
select * from stus where name in('liu','gao','zhan')
-- 不等于一系列值的
select * from stus where name not in('liu','gao')