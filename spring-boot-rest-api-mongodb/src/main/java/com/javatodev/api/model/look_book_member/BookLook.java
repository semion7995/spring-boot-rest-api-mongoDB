package com.javatodev.api.model.look_book_member;

import com.javatodev.api.model.Author;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class BookLook {

    private String id;
    private String name;
    private String isbn;
    private Author author;
    private Instant startOn;
    private Instant dueOn;
}
