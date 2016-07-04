package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Aska on 01.07.2016.
 */
@Entity
@Table(name = "staff", schema = "osbb", catalog = "")
public class StaffEntity {
    private int idStaff;

    @Id
    @Column(name = "id_staff")
    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffEntity that = (StaffEntity) o;

        if (idStaff != that.idStaff) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idStaff;
    }
}
