package org.faezCode.npft.Entity;

import javax.persistence.*;

@Entity
@Table(name = "overall_marks")
public class OverallMarks {

    @Id
    @Column(name = "om_id")
    @GeneratedValue(generator = "sq_overall_marks")
    private int id;

    @OneToOne(targetEntity = Participant.class)
    @JoinColumn(name = "p_id")
    private Participant pId;

    @Column(name = "award_type")
    private String awardType;

    @Column(name = "total_mark")
    private int totalMark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Participant getpId() {
        return pId;
    }

    public void setpId(Participant pId) {
        this.pId = pId;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }
}
