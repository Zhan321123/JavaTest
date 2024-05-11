-- 显示所有权限
show grants
-- 显示某个用户的权限
show grants for 'testuser1'
-- 给予用户所有权限
grant all on studb.* to 'testuser1'
-- 刷新权限
flush privileges
-- 删除权限
revoke all privileges on studb.* from 'testuser1'