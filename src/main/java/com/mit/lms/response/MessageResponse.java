package com.mit.lms.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
