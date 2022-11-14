package com.example.recyclerview12102022;

import java.util.List;

/**
 * Created by pphat on 11/14/2022.
 */
public class Store {
    private int image;
    private long openTime;
    private long closeTime;
    private String name;
    private String address;
    private List<ServiceType> listServiceType;
    private String saleOff;
    private float distance;

    public Store(int image, long openTime, long closeTime, String name, String address, List<ServiceType> listServiceType, String saleOff, float distance) {
        this.image = image;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.name = name;
        this.address = address;
        this.listServiceType = listServiceType;
        this.saleOff = saleOff;
        this.distance = distance;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(long openTime) {
        this.openTime = openTime;
    }

    public long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(long closeTime) {
        this.closeTime = closeTime;
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

    public List<ServiceType> getListServiceType() {
        return listServiceType;
    }

    public void setListServiceType(List<ServiceType> listServiceType) {
        this.listServiceType = listServiceType;
    }

    public String getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(String saleOff) {
        this.saleOff = saleOff;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Store{" +
                "image=" + image +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", listServiceType=" + listServiceType +
                ", saleOff='" + saleOff + '\'' +
                ", distance=" + distance +
                '}';
    }
}
