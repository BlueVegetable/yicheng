package cn.studio.zps.blue.ljy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Article {
    private int id;
    private String title;
    private String content;
    private Timestamp lastModify;
    private String brief;
    private int typeID;
    private Integer topest;

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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "lastModify")
    public Timestamp getLastModify() {
        return lastModify;
    }

    public void setLastModify(Timestamp lastModify) {
        this.lastModify = lastModify;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", lastModify=" + lastModify +
                ", brief='" + brief + '\'' +
                ", typeID=" + typeID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getId() == article.getId() &&
                getTypeID() == article.getTypeID() &&
                Objects.equals(getTitle(), article.getTitle()) &&
                Objects.equals(getContent(), article.getContent()) &&
                Objects.equals(getLastModify(), article.getLastModify());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getContent(), getLastModify(), getTypeID());
    }

    @Basic
    @Column(name = "topest")
    public Integer getTopest() {
        return topest;
    }

    public void setTopest(Integer topest) {
        this.topest = topest;
    }
}
