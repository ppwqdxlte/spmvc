package com.laowang.bean;

import java.util.Objects;

public class Address {

    private String province;
    private String city;
    private String town;

    public Address() {
    }

    public Address(String province, String city, String town) {
        this.province = province;
        this.city = city;
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(province, address.province) && Objects.equals(city, address.city) && Objects.equals(town, address.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(province, city, town);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
