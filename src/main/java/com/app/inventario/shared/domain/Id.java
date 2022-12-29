package com.app.inventario.shared.domain;

public class Id {
    protected String value;

    protected Id(String value) {
        this.value = value;
    }

    public static Id of(String value) {
        return new Id(value);
    }

    public String getValue() {
        return value;
    }
   
   
}
