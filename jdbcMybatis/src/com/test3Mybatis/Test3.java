package com.test3Mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 对sqlSession和sqlSessionFactory的封装
 */
public class Test3 {

    utils utils = new utils();
    @Test
    public void select(){
        SqlSession sql = utils.getSql();
        Object o = sql.selectOne("com.mapper.UserMapper.select3", 1000);
        System.out.println(o);

        utils.closeSql(sql);

    }
}

class utils {
    private static SqlSessionFactory factory = null;

    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis.cfg.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    public SqlSession getSql() {
        return factory.openSession();
    }

    public void closeSql(SqlSession s) {
        if (s != null) {
            s.close();
        }
    }
}
