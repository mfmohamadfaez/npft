package org.faezCode.npft.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "u_user")
public class User {

    @Id
    @Column(name = "u_id")
    @GeneratedValue(generator = "sq_user")
    private int userId;

    @NotNull
    @Column(name = "identity_no")
    private String identityNo;

    @NotNull
    @Column(name = "u_fullname")
    private String userName;

    @NotNull
    @Column(name = "u_password")
    private String password;

    @NotNull
    @Column(name = "u_email")
    private String email;

    @NotNull
    @Column(name = "u_phone")
    private String phoneNo;

    @NotNull
    @Column(name = "u_type")
    private int roleType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", identityNo='" + identityNo + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", roleType=" + roleType +
                '}';
    }
}
