package com.eteration.simplebanking.controller;


public class TransactionStatus {

    private String status;
    private String approvalCode;
    private String message;

    public TransactionStatus(String status, String approvalCode, String message) {
        this.status = status;
        this.approvalCode = approvalCode;
        this.message = message;
    }

    public TransactionStatus(String status) {
        this.status = status;
    }

    public TransactionStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
