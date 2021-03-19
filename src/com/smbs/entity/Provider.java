package com.smbs.entity;


import java.util.Date;

public class Provider {
    private String providerId;
    private String providerName;
    private String description;
    private String telephone;
    private String address;
    private String creator;
    private Date createTime;

    public Provider() {}

    public Provider(String providerId, String providerName, String description, String telephone, String address, String creator, Date createTime) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.description = description;
        this.telephone = telephone;
        this.address = address;
        this.creator = creator;
        this.createTime = createTime;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
