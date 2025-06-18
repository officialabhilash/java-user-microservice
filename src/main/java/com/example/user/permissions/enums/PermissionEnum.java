package com.example.user.permissions.enums;

public enum PermissionEnum {
    CREATE("CREATE"),
    READ("READ"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    private String value;

    PermissionEnum(String value) {
        this.value = value;
    }
}
