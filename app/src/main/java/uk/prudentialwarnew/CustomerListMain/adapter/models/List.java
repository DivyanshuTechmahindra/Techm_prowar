package uk.prudentialwarnew.CustomerListMain.adapter.models;

/**
 * Created by user on 8/10/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class List {

    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("paymentFrequency")
    @Expose
    private String paymentFrequency;
    @SerializedName("products")
    @Expose
    private java.util.List<Product> products = new ArrayList<Product>();
    @SerializedName("y")
    @Expose
    private Integer y;
    @SerializedName("m")
    @Expose
    private Integer m;
    @SerializedName("d")
    @Expose
    private Integer d;
    @SerializedName("bool")
    @Expose
    private Boolean bool;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("index")
    @Expose
    private Integer index;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     *
     * @return
     * The longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     * The latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     * The registered
     */
    public String getRegistered() {
        return registered;
    }

    /**
     *
     * @param registered
     * The registered
     */
    public void setRegistered(String registered) {
        this.registered = registered;
    }

    /**
     *
     * @return
     * The about
     */
    public String getAbout() {
        return about;
    }

    /**
     *
     * @param about
     * The about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The company
     */
    public String getCompany() {
        return company;
    }

    /**
     *
     * @param company
     * The company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     *
     * @return
     * The name
     */
    public Name getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The dob
     */
    public String getDob() {
        return dob;
    }

    /**
     *
     * @param dob
     * The dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The paymentFrequency
     */
    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    /**
     *
     * @param paymentFrequency
     * The paymentFrequency
     */
    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    /**
     *
     * @return
     * The products
     */
    public java.util.List<Product> getProducts() {
        return products;
    }

    /**
     *
     * @param products
     * The products
     */
    public void setProducts(java.util.List<Product> products) {
        this.products = products;
    }

    /**
     *
     * @return
     * The y
     */
    public Integer getY() {
        return y;
    }

    /**
     *
     * @param y
     * The y
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     *
     * @return
     * The m
     */
    public Integer getM() {
        return m;
    }

    /**
     *
     * @param m
     * The m
     */
    public void setM(Integer m) {
        this.m = m;
    }

    /**
     *
     * @return
     * The d
     */
    public Integer getD() {
        return d;
    }

    /**
     *
     * @param d
     * The d
     */
    public void setD(Integer d) {
        this.d = d;
    }

    /**
     *
     * @return
     * The bool
     */
    public Boolean getBool() {
        return bool;
    }

    /**
     *
     * @param bool
     * The bool
     */
    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    /**
     *
     * @return
     * The age
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age
     * The age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @return
     * The picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     *
     * @param picture
     * The picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     *
     * @return
     * The balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     * The balance
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     *
     * @return
     * The status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     *
     * @param guid
     * The guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     *
     * @return
     * The index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     *
     * @param index
     * The index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

}