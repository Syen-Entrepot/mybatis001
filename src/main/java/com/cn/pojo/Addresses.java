package com.cn.pojo;

import java.io.Serializable;

/**
 * @author Syen
 * @date 2019/7/21 0021-下午 14:46
 */

/*implements Serializable 这是序列化*/
public class Addresses implements Serializable {
    private Integer addrId;
    private String country;
    private String city;
    private String state;
    private String Street;
    private String zip;

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "addrId=" + addrId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", Street='" + Street + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

}
