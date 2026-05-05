package com.company.employeescheduling.service;

public class InvalidShiftException extends RuntimeException {
    public InvalidShiftException(String message) {
        super(message);
    }
}
