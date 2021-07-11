package com.spring.springstarter.core;

public class DepartmentNotFoundExeption extends Exception {

    public DepartmentNotFoundExeption() {
        super();
    }

    public DepartmentNotFoundExeption(String message) {
        super(message);
    }
}
