package cn.thinkbam;

import cn.thinkbam.dao.UserAnnotation;
import cn.thinkbam.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 单元测试（基于注解）
 * Mybatis操作步骤：
 * 1.加载mybatis配置文件
 * 2.构建SqlSessionFactory工厂
 * 3.从SqlSessionFactory中获取SqlSession对象
 * 4.通过SqlSession对象操作SQL
 */
public class TestUserAnnotation {
    /**
     * Mybatis配置文件
     */
    String resources = "mybatis-config.xml";
    SqlSession session;

    /**
     * 加载资源
     */
    @Before
    public void before() throws IOException {
        //1.加载mybatis配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resources);
        //2.构建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.从SqlSessionFactory中获取SqlSession对象
        //true:执行完SQL自动执行提交事务，不需要进行手动提交，false:手动提交事务session.commit();
        session = factory.openSession(true);
    }

    /**
     * 关闭SqlSession
     */
    @After
    public void after() {
        session.close();
    }

    /**
     * 根据ID查询用户
     */
    @Test
    public void testGetUserById(){
        UserAnnotation userAnnotation = session.getMapper(UserAnnotation.class);
        User user = userAnnotation.getUserById(1);
        System.out.println("user = " + user);
    }

    /**
     * 获取所有用户
     */
    @Test
    public void testGetUsers(){
        UserAnnotation userAnnotation = session.getMapper(UserAnnotation.class);
        List<User> users = userAnnotation.getUsers();
        System.out.println("users = " + users);
    }

    /**
     * 插入用户
     */
    @Test
    public void testInsertUser(){
        UserAnnotation userAnnotation = session.getMapper(UserAnnotation.class);
        User user = new User();
        user.setName("武松");
        user.setAge(33);
        int affectedRows = userAnnotation.insertUser(user);
        System.out.println("affectedRows = " + affectedRows);
    }

    /**
     * 更新用户
     */
    @Test
    public void testUpdateUser(){
        UserAnnotation userAnnotation = session.getMapper(UserAnnotation.class);
        User user = new User();
        user.setId(1);
        user.setAge(99);
        user.setName("小可爱");
        int affectedRows = userAnnotation.updateUser(user);
        System.out.println("affectedRows = " + affectedRows);
    }

    /**
     * 删除用户
     */
    @Test
    public void testDeleteUserById(){
        UserAnnotation userAnnotation = session.getMapper(UserAnnotation.class);
        int affectedRows = userAnnotation.deleteUserById(5);
        System.out.println("affectedRows = " + affectedRows);
    }
}