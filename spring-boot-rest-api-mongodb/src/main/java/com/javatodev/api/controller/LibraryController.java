package com.javatodev.api.controller;

import com.javatodev.api.model.Author;
import com.javatodev.api.model.Book;
import com.javatodev.api.model.Member;
import com.javatodev.api.model.request.AuthorCreationRequest;
import com.javatodev.api.model.request.BookCreationRequest;
import com.javatodev.api.model.request.BookLendRequest;
import com.javatodev.api.model.request.MemberCreationRequest;
import com.javatodev.api.service.LibraryService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor

public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping(path = "/book")
    public ResponseEntity readBooks(@RequestParam(required = false) String isbn) {
        if (isbn == null) {
            return ResponseEntity.ok(libraryService.readBooks());
        }
        return ResponseEntity.ok(libraryService.readBook(isbn));
    }

    @GetMapping(path = "/book/{bookId}")
    public ResponseEntity<Book> readBook (@PathVariable String bookId) {
        return ResponseEntity.ok(libraryService.readBookById(bookId));
    }

    @GetMapping(path = "/author")
    public ResponseEntity<Author> createAuthor (@RequestParam(required = false) String authorId) {
        return ResponseEntity.ok(libraryService.readAuthorById(authorId));
    }

    @GetMapping(path = "/authors")
    public ResponseEntity readAuthors() {
        return ResponseEntity.ok(libraryService.readAuthors());
    }

    @PostMapping(path = "/book")
    public ResponseEntity<Book> createBook (@RequestBody BookCreationRequest request) {
        return ResponseEntity.ok(libraryService.createBook(request));
    }

    @DeleteMapping(path = "/book/{bookId}")
    public ResponseEntity<Void> deleteBook (@PathVariable String bookId) {
        libraryService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/members")
    public ResponseEntity readMembers() {
        return ResponseEntity.ok(libraryService.readMembers());
    }

    @PostMapping(path = "/member")
    public ResponseEntity<Member> createMember (@RequestBody MemberCreationRequest request) {
        return ResponseEntity.ok(libraryService.createMember(request));
    }

    @PatchMapping(path = "/member/{memberId}")
    public ResponseEntity<Member> updateMember (@RequestBody MemberCreationRequest request, @PathVariable String memberId) {
        return ResponseEntity.ok(libraryService.updateMember(memberId, request));
    }

    @PostMapping(path = "/book/lend")
    public ResponseEntity<List<String>> lendABook(@RequestBody BookLendRequest bookLendRequests) {
        return ResponseEntity.ok(libraryService.lendABook(bookLendRequests));
    }
    @GetMapping(path = "/book/lend")
    public ResponseEntity lendABooks() {
        return ResponseEntity.ok(libraryService.lendABookAll());
    }

    @PostMapping(path = "/author")
    public ResponseEntity<Author> createAuthor (@RequestBody AuthorCreationRequest request) {
        return ResponseEntity.ok(libraryService.createAuthor(request));
    }

}
