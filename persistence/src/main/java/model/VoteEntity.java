package model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Roman on 02.07.2016.
 */

@Entity
@Table(name = "vote", schema = "osbb", catalog = "")
public class VoteEntity {
    private int voteId;
    private Integer idEvent;
    private Integer idUser;
    private Byte voteValue;
    private Timestamp time;

    @Id
    @Column(name = "Vote_id")
    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    @Basic
    @Column(name = "id_event")
    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    @Basic
    @Column(name = "id_user")
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "vote_value")
    public Byte getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(Byte voteValue) {
        this.voteValue = voteValue;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoteEntity that = (VoteEntity) o;

        if (voteId != that.voteId) return false;
        if (idEvent != null ? !idEvent.equals(that.idEvent) : that.idEvent != null) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;
        if (voteValue != null ? !voteValue.equals(that.voteValue) : that.voteValue != null) return false;
        return time != null ? time.equals(that.time) : that.time == null;
    }

    @Override
    public int hashCode() {
        int result = voteId;
        result = 31 * result + (idEvent != null ? idEvent.hashCode() : 0);
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        result = 31 * result + (voteValue != null ? voteValue.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VoteEntity{" +
                "voteId=" + voteId +
                ", idEvent=" + idEvent +
                ", idUser=" + idUser +
                ", voteValue=" + voteValue +
                ", time=" + time +
                '}';
    }
}
