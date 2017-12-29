package cn.thinkbam.domain;

/**
 * THINKBAM.teacher对应的实体类
 */
public class Teacher {
    //定义实体类的属性，与teacher表中的字段对应
    /**
     * 教师ID
     * teacherId->teacher_id
     */
    private int teacherId;
    /**
     * 教师姓名
     * teacherName->teacher_name
     */
    private String teacherName;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
