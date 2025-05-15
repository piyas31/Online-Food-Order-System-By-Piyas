package com.piyas.response;

import com.piyas.model.USER_ROLE;
import com.piyas.model.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;
}
