package com.example.user.groups;

public enum GroupsEnum {
    ADMIN("ADMIN"),
    STUDENT("STUDENT"),
    TEACHER("TEACHER");

    private final String value;

    GroupsEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
