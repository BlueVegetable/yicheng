package cn.studio.zps.blue.ljy.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course_module", schema = "blue14", catalog = "")
public class CourseModule {
    private int id;
    private String courseModuleName;
    private List<CourseType> courseTypes;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "courseModuleName")
    public String getCourseModuleName() {
        return courseModuleName;
    }

    public void setCourseModuleName(String courseModuleName) {
        this.courseModuleName = courseModuleName;
    }

    public List<CourseType> getCourseTypes() {
        return courseTypes;
    }

    public void setCourseTypes(List<CourseType> courseTypes) {
        this.courseTypes = courseTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseModule that = (CourseModule) o;
        return id == that.id &&
                Objects.equals(courseModuleName, that.courseModuleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseModuleName);
    }

    @Override
    public String toString() {
        return "CourseModule{" +
                "id=" + id +
                ", courseModuleName='" + courseModuleName + '\'' +
                ", courseTypes=" + courseTypes +
                '}';
    }
}
