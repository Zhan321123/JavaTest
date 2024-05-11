-- 模糊查询，查询字符串中带有某个字符的方法
-- %是任意数量的任意字符
-- _是单个任意字符
select * from stus where name like '%a%'
select * from stus where name like 'a%'
select * from stus where name like '%a'
select * from stus where name like '_a%'

-- 查询值为空的方法
select * from stus where bonus is null
-- 不为空
select * from stus where bonus is not null

-- 用()来提升优先级
select * from stus where (bonus<300 or bonus>1000) and sallary>2000