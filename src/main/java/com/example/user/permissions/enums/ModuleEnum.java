package com.example.user.permissions.enums;

public enum ModuleEnum {

    USERS("USERS"),
    GROUPS("GROUPS"),
    PERMISSIONS("PERMISSIONS"),
    ORDERS("ORDERS"),
    ORDER_ITEMS("ORDER_ITEMS"),
    JOURNALS("JOURNALS");

    private String value;
    ModuleEnum(String value){
        this.value = value;
    }
}
