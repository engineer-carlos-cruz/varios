package com.company.employeescheduling.service;

public class OverlapException extends RuntimeException {
    public OverlapException(String message) {
        super(message);
    }
}
