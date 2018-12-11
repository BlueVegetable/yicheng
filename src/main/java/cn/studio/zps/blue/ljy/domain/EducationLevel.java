package cn.studio.zps.blue.ljy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "education_level", schema = "blue14", catalog = "")
public class EducationLevel {
    private int id;
    private String name;
    private byte visible;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "visible")
    public byte getVisible() {
        return visible;
    }

    public void setVisible(byte visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationLevel that = (EducationLevel) o;
        return id == that.id &&
                visible == that.visible &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, visible);
    }

    @Override
    public String toString() {
        return "EducationLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", visible=" + visible +
                '}';
    }
}
