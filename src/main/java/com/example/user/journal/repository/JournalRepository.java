package com.example.user.journal.repository;

import com.example.user.journal.entities.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JournalRepository extends JpaRepository<JournalEntity, String> {
    JournalEntity findByUserId();
}
