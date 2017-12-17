package com.hibernate.dto;

import javax.persistence.*;
import java.util.Date;

// Providing new name to Entity
// @Entity(name = "user")

@Entity
@Table(name = "user")   // Providing name to Table
public class UserDetails {

    @Id
    @Column(name = "user_id")
    @GeneratedValue()
    private int userId;

    @Basic(fetch = FetchType.EAGER)  // to user Fetch type use @Basic Annotations
    @Column(name = "user_name")
    private String userName;

    @Transient // to ignore this field, and will not be added to database
    private String password;


    @Temporal(TemporalType.DATE)   // only Date will be stored without timestamp
    private Date joinedDate;

    //private String address;
    @Embedded
    private Address address;

    // Attribute Annotations for Embbeded objects
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column =@Column(name = "office_street")),
            @AttributeOverride(name = "city", column =@Column(name = "office_city_name")),
            @AttributeOverride(name = "state", column =@Column(name = "office_state_name")),
            @AttributeOverride(name = "pincode", column =@Column(name = "office_pincode"))})
    private Address officeAddress;

    @Lob  // Saving Large object (CLOB: form String  or BLOB : byte[])
    private String description;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", joinedDate=" + joinedDate +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
