package com.example.iproject;

public enum GUI {
    SIZE_OF_LOGIN_X(430),
    SIZE_OF_LOGIN_Y(350),
    SIZE_OF_CREATE_X(400),
    SIZE_OF_CREATE_Y(330),
    SIZE_OF_LIST_X(925),
    SIZE_OF_LIST_Y(570),
    SIZE_OF_ADD_X(600),
    SIZE_OF_ADD_Y(400);

    private final int value;

    GUI(final int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
