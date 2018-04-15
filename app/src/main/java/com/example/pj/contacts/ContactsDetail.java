package com.example.pj.contacts;


public class ContactsDetail {

    private String name;
    private String phone;
    private String email;
    private String photoImg;

    public ContactsDetail(String name, String phone, String email, String photoImg) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.photoImg = photoImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoImg() {
        return photoImg;
    }

    public void setPhotoImg(String photoImg) {
        this.photoImg = photoImg;
    }

    @Override
    public String toString() {
        return "ContactsDetail{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", photoImg='" + photoImg + '\'' +
                '}';
    }
}
