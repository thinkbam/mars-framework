package cn.thinkbam;

import cn.thinkbam.domain.Courses;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 单元测试
 * Mybatis操作步骤：
 * 1.加载mybatis配置文件
 * 2.构建SqlSessionFactory工厂
 * 3.从SqlSessionFactory中获取SqlSession对象
 * 4.通过SqlSession对象操作SQL
 */
public class TestCourses {
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
     * 根据ID获取课程信息
     */
    @Test
    public void testGetCoursesById(){
        String statement = "cn.thinkbam.domain.Courses.getCoursesById";
        Courses courses = session.selectOne(statement,1);
        System.out.println("courses = " + courses);
    }

    /**
     * 根据ID获取课程信息
     */
    @Test
    public void testGetCourses1(){
        String statement = "cn.thinkbam.domain.Courses.getCourses1";
        //执行查询操作，将查询结果自动封装成Order对象返回
        Courses courses = session.selectOne(statement,1);
        System.out.println("courses = " + courses);
    }

    /**
     * 根据ID获取课程信息
     */
    @Test
    public void testGetCourses2(){
        String statement = "cn.thinkbam.domain.Courses.getCourses2";
        //执行查询操作，将查询结果自动封装成Order对象返回
        Courses courses = session.selectOne(statement,2);
        System.out.println("courses = " + courses);
    }
}