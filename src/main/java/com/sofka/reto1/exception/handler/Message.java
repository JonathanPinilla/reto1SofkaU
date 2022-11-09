package com.sofka.reto1.exception.handler;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Message {
    private String exception;
    private String message;
    private String path;
    private LocalDateTime timestamp;

    public Message(Exception excepcion, String path) {
        this.exception = excepcion.getClass().getSimpleName();
        this.message = excepcion.getMessage();
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "timestamp=" + timestamp +
                ", exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
