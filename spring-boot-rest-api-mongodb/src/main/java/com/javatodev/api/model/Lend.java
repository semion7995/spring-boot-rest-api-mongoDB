package com.javatodev.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Document
public class Lend {
    @Id
    private String id;
    private LendStatus status;
    private Instant startOn;
    private Instant dueOn;
    @DBRef
    private Book book;
    @DBRef
    private Member member;

}
