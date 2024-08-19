package com.automation.ui.service;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserLoginDetails {

    private final String email;
    private final String password;
}
