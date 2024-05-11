package com.test3Mybatis;

import com.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis对单表的更多操作以及细节
 */
public class Test2 {
    @Test
    public void select1() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = factory.openSession();
        Object o = sqlSession.selectOne("com.mapper.UserMapper.select3", 1000);
        System.out.println(o);

        sqlSession.close();
    }
    @Test
    public void insert1() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //参数true就自动提交，否则要手动提交
        //factory.openSession(true),默认时false
        SqlSession sqlSession = factory.openSession();

        User u = new User("zhou","zzz","zxc",100);

        try {
            int i = sqlSession.insert("com.mapper.UserMapper.insert1", u);
            System.out.println(i);
            //事务提交
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

    }
    @Test
    public void update1() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();

        User u = new User();
        u.setName("yao");
        u.setPassword("zz");
        u.setAccount("zzz");
        int i = sqlSession.update("com.mapper.UserMapper.update1", u);
        System.out.println(i);
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void delete1() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();

        int i = sqlSession.delete("com.mapper.UserMapper.delete1", "yao");
        System.out.println(i);
        sqlSession.commit();

        sqlSession.close();
    }

}
