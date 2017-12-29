package cn.thinkbam.domain;

/**
 * THINKBAM.COURSES表对应的实体类
 */
public class Courses {
    /**
     * CREATE TABLE `courses` (
     * `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
     * `courses_name` varchar(200) NOT NULL COMMENT '课程名称',
     * `courses_sub` varchar(100) NOT NULL COMMENT '课程所属学科',
     * PRIMARY KEY (`courses_id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */
    private int coursesId;
    private String coursesName;
    private String coursesSub;

    public int getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(int coursesId) {
        this.coursesId = coursesId;
    }

    public String getCoursesName() {
        return coursesName;
    }

    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName;
    }

    public String getCoursesSub() {
        return coursesSub;
    }

    public void setCoursesSub(String coursesSub) {
        this.coursesSub = coursesSub;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "coursesId=" + coursesId +
                ", coursesName='" + coursesName + '\'' +
                ", coursesSub='" + coursesSub + '\'' +
                '}';
    }
}
