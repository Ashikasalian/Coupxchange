package com.example.coupxchange;


public class Token {
    private String userEmail;
    private String companyId;
    private String couponCode;
    private String description;

    public Token(String userEmail,String companyId, String couponCode, String description) {
        this.userEmail=userEmail;
        this.companyId = companyId;
        this.couponCode = couponCode;
        this.description = description;
    }

    public Token() {
        // Required empty constructor
    }

    public String getCompanyId() {
        return companyId;
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

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

