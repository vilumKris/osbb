package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by nazar.dovhyy on 02.07.2016.
 */
@Entity
@Table(name = "report", schema = "public", catalog = "osbb")
public class ReportEntity {
    private int reportId;
    private String name;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    private String filepath;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "datecreation")
    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }


    @Basic
    @Column(name = "filepath")
    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportEntity that = (ReportEntity) o;

        if (reportId != that.reportId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (datecreation != null ? !datecreation.equals(that.datecreation) : that.datecreation != null) return false;
        if (filepath != null ? !filepath.equals(that.filepath) : that.filepath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reportId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (datecreation != null ? datecreation.hashCode() : 0);
        result = 31 * result + (filepath != null ? filepath.hashCode() : 0);
        return result;
    }
}
