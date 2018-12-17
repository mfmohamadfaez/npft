package org.faezCode.npft.Entity;

import javax.persistence.*;

@Entity(name = "Test")
@Table(name = "test")
public class Tests {

    @Id
    @Column(name = "test_id")
    @GeneratedValue(generator = "sq_test")
    private int id;

    @Column(name = "test_name")
    private String testName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return "Tests{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                '}';
    }
}
