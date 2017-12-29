package cn.thinkbam.domain;

/**
 * THINKBAM.CLASS表对应的实体类
 */
public class Classes {
    //定义实体类的属性，与class表中的字段对应
    /**
     * 班级ID
     * classId->class_id
     */
    private int classId;
    /**
     * 班级姓名
     * className->class_name
     */
    private String className;
    /**
     * class表中有一个teacher_id字段，所以在Classes类中定义一个teacher属性，
     * 用于维护teacher和class之间的一对一关系，通过这个teacher属性就可以知道这个班级是由哪个老师负责的
     */
    private Teacher teacher;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
