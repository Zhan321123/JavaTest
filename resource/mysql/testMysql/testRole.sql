-- 新建角色
create role 'testrole1'
-- 给角色赋予权限
grant all on studb.* to 'testrole1'
-- 把角色给用户
grant 'testrole1' to 'testuser1'
-- 激活角色权限
set default role all to 'testrole1'
-- 删除角色
drop user 'testrole1'