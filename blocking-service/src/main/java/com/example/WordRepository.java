package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    @Query(value = """
            SELECT id, text
            FROM word
            ORDER BY RAND()
            LIMIT :limit
            """,
            nativeQuery = true)
    List<Word> findWords(int limit);

}
