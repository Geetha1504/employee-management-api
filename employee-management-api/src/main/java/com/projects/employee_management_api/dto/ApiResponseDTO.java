package com.projects.employee_management_api.dto;

public class ApiResponseDTO {

    private String message;

    public ApiResponseDTO() {
    }

    public ApiResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}