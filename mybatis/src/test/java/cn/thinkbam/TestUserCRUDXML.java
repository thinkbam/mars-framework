package cn.thinkbam;

import cn.thinkbam.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单元测试(基于XML),优化版本
 * Mybatis操作步骤：
 * 1.加载mybatis配置文件
 * 2.构建SqlSessionFactory工厂
 * 3.从SqlSessionFactory中获取SqlSession对象
 * 4.通过SqlSession对象操作SQL
 */
public class TestUserCRUDXML {

    /**
     * Mybatis配置文件
     */
    String resoure = "mybatis-config.xml";

    SqlSession session;

    /**
     * 加载资源
     */
    @Before
    public void before() throws IOException {
        //1.加载mybatis配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resoure);
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
    public void after(){
        session.close();
    }

    /**
     * 根据ID查询用户
     */
    @Test
    public void testGetUser() {
        String statement = "cn.thinkbam.domain.User.getUser";
        User user = session.selectOne(statement, 1);
        System.out.println("user = " + user);
    }

    /**
     * 查询用户列表1
     */
    @Test
    public void testGetUsers1() {
        String statement = "cn.thinkbam.domain.User.getUsers1";
        List<User> users = session.selectList(statement);
        System.out.println("users = " + users);
    }

    /**
     * 查询用户列表2
     */
    @Test
    public void testGetUsers2() {
        String statement = "cn.thinkbam.domain.User.getUsers2";
        List<User> users = session.selectList(statement);
        System.out.println("users = " + users);
    }

    /**
     * 查询用户列表3
     */
    @Test
    public void testGetUsers3() {
        String statement = "cn.thinkbam.domain.User.getUsers3";
        List<User> users = session.selectList(statement);
        System.out.println("users = " + users);
    }

    /**
     * 添加用户1
     */
    @Test
    public void testInsertUser1() {
        String statement = "cn.thinkbam.domain.User.insertUser1";
        User user = new User();
        user.setName("Dell");
        user.setAge(53);
        int affectedRows = session.insert(statement, user);
        System.out.println("affectedRows = " + affectedRows);
    }

    /**
     * 添加用户2
     */
    @Test
    public void testInsertUser2() {
        String statement = "cn.thinkbam.domain.User.insertUser2";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "李想");
        map.put("age", 21);
        int affectedRows = session.insert(statement, map);
        System.out.println("affectedRows = " + affectedRows);
    }

    /**
     * 根据ID更新用户信息
     */
    @Test
    public void testUpdateUser() {
        String statement = "cn.thinkbam.domain.User.updateUser";
        User user = new User();
        user.setId(1);
        user.setAge(50);
        user.setName("张三丰");
        int affectedRows = session.update(statement, user);
        System.out.println("affectedRows = " + affectedRows);
    }

    /**
     * 根据ID删除用户
     */
    @Test
    public void testDeleteUser() {
        String statement = "cn.thinkbam.domain.User.deleteUser";
        int affectedRows = session.delete(statement, 3);
        System.out.println("affectedRows = " + affectedRows);
    }
}
