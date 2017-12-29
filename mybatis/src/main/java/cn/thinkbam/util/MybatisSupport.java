package cn.thinkbam.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Mybatis工具类
 */
public class MybatisSupport {
    /**
     * Mybatis配置文件
     */
    private static  final  String resources = "mybatis-config.xml";
    /**
     * 获取SqlSession
     * @param autoCommit 是否开启自动提交
     * @return
     */
    public static SqlSession getSession(boolean autoCommit){
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader(resources);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            session = factory.openSession(autoCommit);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  session;
    }
    /**
     * 获取SqlSession，自动提交事务
     * @return
     */
    public static SqlSession getSession(){
        return getSession(true);
    }
}
