package com.hibernate.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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


    @Lob  // Saving Large object (CLOB: form String  or BLOB : byte[])
    private String description;


    @ElementCollection      // Mark Address to persist in db as collection
    private Set<Address> listOfAddress = new HashSet<Address>();

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

    public Set<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Set<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
