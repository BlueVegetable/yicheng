package cn.studio.zps.blue.ljy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "module_picture", schema = "blue14", catalog = "")
public class ModulePicture {
    private int id;
    private String path;
    private String url;
    private int moduleID;

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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModulePicture that = (ModulePicture) o;
        return id == that.id &&
                Objects.equals(path, that.path) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, url);
    }
}
