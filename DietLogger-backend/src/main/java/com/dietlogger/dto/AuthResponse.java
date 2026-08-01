package com.dietlogger.dto;

public class AuthResponse {

    private String token;
    private Long id;
    private String userid;

    public AuthResponse(String token, Long id, String userid) {
        this.token = token;
        this.id = id;
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }
}
