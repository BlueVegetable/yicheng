package cn.studio.zps.blue.ljy.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course_type", schema = "blue14", catalog = "")
public class CourseType {
    private int id;
    private String courseTypeName;
    private int courseModuleID;
    private List<Course> courses;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "courseTypeName")
    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public int getCourseModuleID() {
        return courseModuleID;
    }

    public void setCourseModuleID(int courseModuleID) {
        this.courseModuleID = courseModuleID;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseType that = (CourseType) o;
        return id == that.id &&
                Objects.equals(courseTypeName, that.courseTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseTypeName);
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "id=" + id +
                ", courseTypeName='" + courseTypeName + '\'' +
                ", courseModuleID=" + courseModuleID +
                ", courses=" + courses +
                '}';
    }
}
