package com.javatodev.api.model.look_book_member;
import com.javatodev.api.model.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Getter
@Setter
public class MemberBook {
    private String memberId;
    private String firstName;
    private String lastName;



    @DBRef
    private List<BookLook> booksOnHand;
}
