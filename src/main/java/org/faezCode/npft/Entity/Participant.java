package org.faezCode.npft.Entity;

import javax.persistence.*;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(generator = "sq_participant")
    private int id;

    @Column(name = "p_body_no")
    private int bodyNo;

    @Column(name = "p_fullname")
    private String name;

    @Column(name = "p_turn_no")
    private int turnNo;

    @Column(name = "p_nric_no")
    private String nricNo;

    @Column(name = "p_age")
    private int age;

    @Column(name = "p_gender")
    private char gender;

    @Column(name = "p_height")
    private double height;

    @Column(name = "p_weight")
    private double weight;

    public Participant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBodyNo() {
        return bodyNo;
    }

    public void setBodyNo(int bodyNo) {
        this.bodyNo = bodyNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTurnNo() {
        return turnNo;
    }

    public void setTurnNo(int turnNo) {
        this.turnNo = turnNo;
    }

    public String getNricNo() {
        return nricNo;
    }

    public void setNricNo(String nricNo) {
        this.nricNo = nricNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", bodyNo=" + bodyNo +
                ", name='" + name + '\'' +
                ", turnNo=" + turnNo +
                ", nricNo='" + nricNo + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
