package cn.studio.zps.blue.ljy.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Article {
    private int id;
    private String title;
    private String content;
    private Timestamp lastModify;
    private int typeID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", lastModify=" + lastModify +
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
}
