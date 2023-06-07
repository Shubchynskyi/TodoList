package com.example.todolist.entity;

public enum Status {
    IN_PROGRESS("IN PROGRESS"),
    DONE("DONE"),
    PAUSED("PAUSED");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
