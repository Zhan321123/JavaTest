-- 索引
show index from stus

-- 给元素添加索引
create index index_stus_name on stus(name)
select * from stus where name='liu'
-- 删除某个索引
drop index index_stus_name on stus

