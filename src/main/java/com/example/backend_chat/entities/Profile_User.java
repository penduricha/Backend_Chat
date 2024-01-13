package com.example.backend_chat.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Profile_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Profile")
    private Long id_Profile;
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String phoneProfile;
    @Column(columnDefinition = "nvarchar(50)",nullable = false)
    private String fullName;

    private boolean gender;
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String email;

    private Date dateOfBirth;
    @Lob
    @Column(name = "image_avatar", columnDefinition="BLOB")
    private byte[] image_Avatar;
    //Nối với Account
    @OneToOne(mappedBy = "profileUser", cascade = CascadeType.ALL)
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile_User)) return false;
        Profile_User profileUser = (Profile_User) o;
        return phoneProfile.equals(profileUser.phoneProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneProfile);
    }
    public Long getId_Profile() {
        return id_Profile;
    }

    public void setId_Profile(Long id_Profile) {
        this.id_Profile = id_Profile;
    }

    public String getPhoneProfile() {
        return phoneProfile;
    }

    public void setPhoneProfile(String phoneProfile) {
        this.phoneProfile = phoneProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getImage_Avatar() {
        return image_Avatar;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setImage_Avatar(byte[] image_Avatar) {
        this.image_Avatar = image_Avatar;
    }

    public Profile_User() {
    }

    public Profile_User(String phoneProfile, String fullName, boolean gender, String email, Date dateOfBirth,byte[] image_Avatar) {
        this.phoneProfile = phoneProfile;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.image_Avatar = image_Avatar;
    }
}
