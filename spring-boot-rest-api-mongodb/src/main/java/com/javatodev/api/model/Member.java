package com.javatodev.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document
public class Member {
    private String id;
    private String firstName;
    private String lastName;
    private MemberStatus status;

}
