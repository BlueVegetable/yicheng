package cn.studio.zps.blue.ljy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {
    private int id;
    private String title;
    private Date date;
    private String teacher;
    private String imgUrl;
    private String teacherPic1;
    private String teacherPic2;
    private List<Video> videoes;
    private int courseTypeID;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "teacher")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "imgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "teacherPic1")
    public String getTeacherPic1() {
        return teacherPic1;
    }

    public void setTeacherPic1(String teacherPic1) {
        this.teacherPic1 = teacherPic1;
    }

    @Basic
    @Column(name = "teacherPic2")
    public String getTeacherPic2() {
        return teacherPic2;
    }

    public void setTeacherPic2(String teacherPic2) {
        this.teacherPic2 = teacherPic2;
    }

    public List<Video> getVideoes() {
        return videoes;
    }

    public void setVideoes(List<Video> videoes) {
        this.videoes = videoes;
    }

    public int getCourseTypeID() {
        return courseTypeID;
    }

    public void setCourseTypeID(int courseTypeID) {
        this.courseTypeID = courseTypeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                Objects.equals(title, course.title) &&
                Objects.equals(date, course.date) &&
                Objects.equals(teacher, course.teacher) &&
                Objects.equals(imgUrl, course.imgUrl) &&
                Objects.equals(teacherPic1, course.teacherPic1) &&
                Objects.equals(teacherPic2, course.teacherPic2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, teacher, imgUrl, teacherPic1, teacherPic2);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", teacher='" + teacher + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", teacherPic1='" + teacherPic1 + '\'' +
                ", teacherPic2='" + teacherPic2 + '\'' +
                ", videoes=" + videoes +
                ", courseTypeID=" + courseTypeID +
                '}';
    }
}
