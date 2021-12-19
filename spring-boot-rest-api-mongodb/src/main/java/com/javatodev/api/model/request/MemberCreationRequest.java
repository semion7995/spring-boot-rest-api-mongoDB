package com.javatodev.api.model.request;

import lombok.Data;

import java.util.List;

@Data
public class MemberCreationRequest {
    private String firstName;
    private String lastName;

}
