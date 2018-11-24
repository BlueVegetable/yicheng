package cn.studio.zps.blue.ljy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "home_page_picture", schema = "blue14", catalog = "")
public class HomePagePicture {
    private int id;
    private String image;
    private String url;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomePagePicture that = (HomePagePicture) o;
        return id == that.id &&
                Objects.equals(image, that.image) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, url);
    }
}
