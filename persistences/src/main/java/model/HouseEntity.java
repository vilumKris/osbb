package model;

import javax.persistence.*;

/**
 * Created by nazar.dovhyy on 02.07.2016.
 */
@Entity
@Table(name = "house", schema = "public", catalog = "osbb")
public class HouseEntity {
    private int houseId;
    private String address;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseEntity that = (HouseEntity) o;

        if (houseId != that.houseId) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = houseId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
