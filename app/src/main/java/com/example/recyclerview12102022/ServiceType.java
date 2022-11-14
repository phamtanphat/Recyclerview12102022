package com.example.recyclerview12102022;

/**
 * Created by pphat on 11/14/2022.
 */
public enum ServiceType {
    RESTAURANT("Nhà hàng"),
    BIRTH_DAY("Sinh nhật"),
    FAMILY("Gia đình"),
    GROUP("Hội nhóm"),
    SHOP_ONLINE("Shop Online"),
    STREET_FOOD("Đồ ăn đường phố"),
    BUFFET("Buffer");

    private final String name;

    ServiceType(String s) {
        name = s;
    }

    public String toString() {
        return name;
    }
}
