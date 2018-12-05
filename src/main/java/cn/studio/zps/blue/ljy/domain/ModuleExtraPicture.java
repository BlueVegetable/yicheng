package cn.studio.zps.blue.ljy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "module_extra_picture", schema = "blue14", catalog = "")
public class ModuleExtraPicture {
    private int id;
    private String path;
    private String url;
    private int moduleId;

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

    @Basic
    @Column(name = "moduleID")
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleExtraPicture that = (ModuleExtraPicture) o;
        return id == that.id &&
                moduleId == that.moduleId &&
                Objects.equals(path, that.path) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, url, moduleId);
    }
}
