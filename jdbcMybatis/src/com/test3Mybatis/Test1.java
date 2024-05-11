package com.test3Mybatis;

import com.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 简单的实现访问数据库
 *
 * mybatis环境配置：
 * 一、导入jar包到lib里，并在项目结构里添加
 * 二、用两个包entity和mapper分别装{user.java}对象类及其{userMapper.xml}
 *      entity包下装"类名.java"，mapper包下装 "类名Mapper.xml"
 * 三、配置mybatis.cfg.xml文件到src包下
 *      里面包含数据源的配置，driver，url，username，password
 * 四、配置log4j测试环境
 *      1.配置log4j.properties文件到src包下
 *      2.找一个文件路径装log.txt文件
 *      3.在测试的方法上注解 @Test
 *
 */
public class Test1 {

    //Junit包的测试体注解Test
    @Test
    public void TestSelectAll() throws IOException {
        //Resources.getResourceAsStream("mybatis.cfg.xml")，加载该xml文件
        InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = factory.openSession();
        //SqlSession.selectList(Mapper路径.selectId)，返回List<类>
        List<User> list = sqlSession.selectList("com.mapper.UserMapper.selectAll");

        sqlSession.close();
        list.forEach(System.out::println);
    }

    @Test
    public void TestSelect1() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = factory.openSession();
        //SqlSession.selectOne(id，占位符的值)，返回具体对象
        User u = sqlSession.selectOne("com.mapper.UserMapper.select1","liu");

        sqlSession.close();
        System.out.println(u);
    }

    @Test
    public void TestSelect2() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = factory.openSession();

        User u = new User();
        u.setMoney(1000);
        u.setName("liu");
        //selectList(id，对象)，提前将对象值赋好，会自动匹配对应的
        List<User> list1 = sqlSession.selectList("com.mapper.UserMapper.select2",u);
        list1.forEach(System.out::println);

        sqlSession.close();
    }
}
