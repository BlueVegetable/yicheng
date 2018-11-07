package cn.studio.zps.blue.ljy.domain;

public class Address {

    private int id;
    private String name;
    private String address;
    private String route;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Address(String name, String address, String route) {
        this.name = name;
        this.address = address;
        this.route = route;
    }

    public Address(int id, String name, String address, String route) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.route = route;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
