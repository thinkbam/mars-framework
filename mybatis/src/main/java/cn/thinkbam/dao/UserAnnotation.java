package cn.thinkbam.dao;

import cn.thinkbam.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 定义sql映射的接口,基于注解实现SQL crud操作
 * 使用注解标明方法要执行的SQL语句
 */
public interface UserAnnotation {
    /**
     * 根据ID获取用户
     * 使用@Select注解标明getUserById方法要执行的SQL
     * @param id 用户ID
     * @return
     */
    @Select("select id,name,age from users where id=#{id}")
    public User getUserById(int id);

    /**
     * 获取所有用户
     * 使用@Select注解标明getUsers方法要执行的SQL
     * @return
     */
    @Select("select id,name,age from users")
    public List<User> getUsers();

    /**
     * 添加用户
     * 使用@Insert注解标明insertUser方法要执行的SQL
     * @param user
     * @return
     */
    @Insert("insert into users(name,age) values(#{name},#{age})")
    public int insertUser(User user);

    /**
     * 更新用户信息
     * 使用@Update注解标明updateUser方法要执行的SQL
     * @param user
     * @return
     */
    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    public int updateUser(User user);

    /**
     * 根据ID删除用户
     * 使用@Delete注解标明deleteUserById方法要执行的SQL
     * @param id
     * @return
     */
    @Delete("delete from users where id=#{id}")
    public int deleteUserById(int id);
}
