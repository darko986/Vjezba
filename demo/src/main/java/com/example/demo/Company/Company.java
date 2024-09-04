package com.example.demo.Company;

public class Company {
    private String name;
    private String address;
    private String phone;
    private final Long ID;

    public Company(Long ID, String phone, String address, String name) {
        this.ID = ID;
        this.phone = phone;
        this.address = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", ID=" + ID +
                '}';
    }
}
