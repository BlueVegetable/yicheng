package cn.studio.zps.blue.ljy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Module {
    private int id;
    private String moduleName;
    private String bannerPcState;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "moduleName")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return id == module.id &&
                Objects.equals(moduleName, module.moduleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleName);
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }

    @Basic
    @Column(name = "bannerPCState")
    public String getBannerPcState() {
        return bannerPcState;
    }

    public void setBannerPcState(String bannerPcState) {
        this.bannerPcState = bannerPcState;
    }
}
