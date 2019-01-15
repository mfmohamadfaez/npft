package org.faezCode.npft.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(generator = "sq_participant")
    private int id;

    @Column(name = "p_body_no")
    @NotNull
    private Integer bodyNo;

    @Column(name = "p_fullname")
    @Size(min=2)
    @NotNull
    private String name;

    @Column(name = "p_turn_no")
    @NotNull
    private Integer turnNo;

    @Column(name = "p_nric_no")
    @NotNull
    @Size(min=14)
    private String nricNo;

    @Column(name = "p_age")
    @NotNull
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private Integer age;

    @Column(name = "p_gender")
    @NotNull
    private char gender;

    @Column(name = "p_height")
    @NotNull
    @Min(value = 1, message = "Height should not be less than 1")
    private Double height;

    @Column(name = "p_weight")
    @NotNull
    @Min(value = 1, message = "Height should not be less than 1")
    private Double weight;

    public Participant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBodyNo() {
        return bodyNo;
    }

    public void setBodyNo(Integer bodyNo) {
        this.bodyNo = bodyNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTurnNo() {
        return turnNo;
    }

    public void setTurnNo(Integer turnNo) {
        this.turnNo = turnNo;
    }

    public String getNricNo() {
        return nricNo;
    }

    public void setNricNo(String nricNo) {
        this.nricNo = nricNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
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
