package com.smbs.entity;

import java.util.Date;

public class Bill {
    private String billId;
    private String productName;
    private String productDesc;
    private int productCount;
    private double totalPrice;
    private int isPayment;
    private int providerId;
    private String creator;
    private Date createTime;

    public Bill() {

    }

    public Bill(String billId, String productName, String productDesc, int productCount, double totalPrice, int isPayment, int providerId, String creator, Date createTime) {
        this.billId = billId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
        this.providerId = providerId;
        this.creator = creator;
        this.createTime = createTime;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int isPayment() {
        return isPayment;
    }

    public void setPayment(int payment) {
        isPayment = payment;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
