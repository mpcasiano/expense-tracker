package com.expense.tracker.controller.error;

import lombok.Data;

@Data
public class ErrorResponse {
    private String code;
    private String message;
    private String details;
}
