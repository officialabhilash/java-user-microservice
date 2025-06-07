package com.example.user.journal.services;

import com.example.user.journal.dto.JournalDto;
import com.example.user.journal.entities.JournalEntity;
import com.example.user.journal.repository.JournalRepository;
import com.example.user.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveJournal(JournalDto journal) throws ChangeSetPersister.NotFoundException {
        if (journal.getUserId() != null) {
            JournalEntity newJournal = JournalEntity.builder().
                    title(journal.getTitle()).
                    content(journal.getContent()).
                    user(userRepository.findById(journal.getUserId()).orElseThrow(ChangeSetPersister.NotFoundException::new)).
                    build();

            journalRepository.save(newJournal);
        }
    }

    public List<JournalDto> getAll() {

        return journalRepository.findAll().parallelStream().map(x->JournalDto.builder().
                content(x.getContent()).
                userId(x.getUser().getId()).
                id(x.getId()).
                title(x.getTitle()).
                build()).collect(Collectors.toList());
    }

    public JournalDto getJournalById(Long id) {

        JournalEntity journalEntity = journalRepository.findById(id.toString()).orElseThrow(EntityNotFoundException::new);
        return JournalDto.builder().
                id(journalEntity.getId()).
                title(journalEntity.getTitle()).
                content(journalEntity.getContent()).
                build();
    }

    public JournalDto updateJournalById(Long id, JournalDto journalData) {
        JournalEntity old = journalRepository.findById(id.toString()).orElseThrow(EntityNotFoundException::new);
        old.setTitle(journalData.getTitle() != null && !journalData.getTitle().equals("") ? journalData.getTitle() : old.getTitle());
        old.setContent(journalData.getContent() != null && !journalData.getContent().equals("") ? journalData.getContent() : old.getContent());
        journalRepository.save(old);
        return JournalDto.builder().
                id(old.getId()).
                content(old.getContent()).
                userId(old.getUser().getId()).
                title(old.getTitle()).
                build();
    }

    public boolean deleteJournalById(Long id){
        boolean isJournalExists = journalRepository.existsById(id.toString());
        if (isJournalExists) {
            journalRepository.deleteById(id.toString());
            return true;
        }
        return false;
    }
}
