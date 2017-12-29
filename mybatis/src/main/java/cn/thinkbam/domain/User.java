package cn.thinkbam.domain;

/**
 * THINKBAM.USER表对应的实体类
 */
public class User {
    /**
     * ID
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    /**
     * 设置ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取ID
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 获取名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置年龄
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
