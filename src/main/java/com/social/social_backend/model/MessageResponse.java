// MessageResponse.java
package com.social.social_backend.model;

import java.time.LocalDateTime;

public class MessageResponse {
    private boolean success;
    private String message;
    private Integer messageId;
    private LocalDateTime messageDate;

    // Constructores
    public MessageResponse() {}

    public MessageResponse(boolean success, String message, Integer messageId, LocalDateTime messageDate) {
        this.success = success;
        this.message = message;
        this.messageId = messageId;
        this.messageDate = messageDate;
    }

    // Getters y setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public LocalDateTime getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }
}