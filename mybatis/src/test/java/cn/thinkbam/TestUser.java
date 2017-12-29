package cn.thinkbam;

import cn.thinkbam.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * 单元测试,初级版本
 */
public class TestUser {
    /**
     * 获取用户
     */
    @Test
    public void testGetUser() {
        //mybatis的配置文件
        String resource = "mybatis-config.xml";


        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = TestUser.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);


        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);


        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * cn.thinkbam.domain.User是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "cn.thinkbam.domain.User.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }

    /**
     * 获取用户列表
     */
    @Test
    public void testGetUsers() throws IOException {
        //1.加载Mybatis配置文件
        String config = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(config);

        //2.构建 SqlSessionFactory 工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //3.从 SqlSessionFactory 中获取 SqlSession
        SqlSession session = factory.openSession();

        //4.SQL操作
        String statement = "cn.thinkbam.domain.User.getUsers1";
        List<User> users = session.selectList(statement);
        System.out.println("users=" + users);

//        String statement2 = "cn.thinkbam.domain.User.getUsers2";
//        List users2 =  session.selectList(statement2);
//        System.out.println("users2=" + users2);

    }
}
