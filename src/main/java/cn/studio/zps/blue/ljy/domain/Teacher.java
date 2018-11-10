package cn.studio.zps.blue.ljy.domain;

public class Teacher {

    private int id;
    private String path;
    private String name;
    private String identity;
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Teacher() {
    }

    public Teacher(int id ,String path, String name, String identity, String info) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.identity = identity;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
