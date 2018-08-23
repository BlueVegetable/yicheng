package cn.studio.zps.blue.ljy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Consult {
    private int id;
    private String name;
    private String remark;
    private String phoneNumber;
    private Integer state;
    private Timestamp createTime;
    private String attribution;

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
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "attribution")
    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consult consult = (Consult) o;

        if (id != consult.id) return false;
        if (name != null ? !name.equals(consult.name) : consult.name != null) return false;
        if (remark != null ? !remark.equals(consult.remark) : consult.remark != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(consult.phoneNumber) : consult.phoneNumber != null) return false;
        if (state != null ? !state.equals(consult.state) : consult.state != null) return false;
        if (createTime != null ? !createTime.equals(consult.createTime) : consult.createTime != null) return false;
        if (attribution != null ? !attribution.equals(consult.attribution) : consult.attribution != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (attribution != null ? attribution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", attribution='" + attribution + '\'' +
                '}';
    }
}
