package com.example.coupxchange;

public class companyWise {

    private String userEmail;
    private String couponCode;
    private String description;

    public companyWise(String couponCode, String description,String userEmail) {
        this.userEmail=userEmail;
        this.couponCode = couponCode;
        this.description = description;
    }


    public String getCouponCode() {
        return couponCode;
    }

    public String getDescription() {
        return description;
    }

    public String getUserEmail() {
        return userEmail;
    }


    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}


