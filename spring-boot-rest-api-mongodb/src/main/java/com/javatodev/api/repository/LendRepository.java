package com.javatodev.api.repository;

import com.javatodev.api.model.Book;
import com.javatodev.api.model.Lend;
import com.javatodev.api.model.LendStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LendRepository extends MongoRepository<Lend, String> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}
