package org.faezCode.npft.Entity;

import javax.persistence.*;

@Entity
@Table(name = "test_result")
public class TestResult {

   /* TR_ID BIGINT PRIMARY KEY NOT NULL,
    P_ID BIGINT REFERENCES PARTICIPANT(P_ID),
    TEST_ID BIGINT REFERENCES TEST(TEST_ID),
    MARK INT NOT NULL,
    SCORE INT NOT NULL*/

   @Id
   @Column(name = "tr_id")
   @GeneratedValue(generator = "sq_test_result")
   private int id;

   @OneToOne(targetEntity = Participant.class)
   @JoinColumn(name = "p_id")
   private Participant pId;

   @OneToOne(targetEntity = Tests.class)
   @JoinColumn(name = "test_id")
   private Tests testId;

   @Column(name = "mark")
   private String mark;

   @Column(name = "score")
   private int score;

    public TestResult() {
    }

    public TestResult(Participant pId, Tests testId, String mark, int score) {
        this.pId = pId;
        this.testId = testId;
        this.mark = mark;
        this.score = score;
    }

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

    public Tests getTestId() {
        return testId;
    }

    public void setTestId(Tests testId) {
        this.testId = testId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", pId=" + pId +
                ", testId=" + testId +
                ", mark=" + mark +
                ", score=" + score +
                '}';
    }
}
