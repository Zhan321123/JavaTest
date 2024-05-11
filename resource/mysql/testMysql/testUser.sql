-- 新建用户
create user 'testuser1' identified by '123456'
create user 'testuser2'@'localhost' identified by '123456'

select * from user
-- 设置密码
set password for 'testuser1' = '123456789'
-- 删除用户
drop user 'testuser1'@'localhost'