package cn.studio.zps.blue.ljy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banner {
    private int id;
    private String path;
    private boolean visible;
    private int position;
    private String type;
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
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "visible")
    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Basic
    @Column(name = "position")
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banner banner = (Banner) o;

        if (id != banner.id) return false;
        if (position != banner.position) return false;
        if (path != null ? !path.equals(banner.path) : banner.path != null) return false;
        if (visible!=banner.visible) return false;
        if (type != null ? !type.equals(banner.type) : banner.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (visible?1:0);
        result = 31 * result + position;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", visible=" + visible +
                ", position=" + position +
                ", type='" + type + '\'' +
                '}';
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
