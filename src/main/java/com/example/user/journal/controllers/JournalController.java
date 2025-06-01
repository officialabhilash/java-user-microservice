package com.example.user.journal.controllers;

import com.example.user.core.controllers.BaseController;
import com.example.user.journal.dto.JournalDto;
import com.example.user.journal.entities.JournalEntity;
import com.example.user.journal.services.JournalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Convention is : controller --> service --> repository


@RestController
@RequestMapping("/journals")
@Tag(name = "Journal Management", description = "APIs for managing journal entries")
public class JournalController extends BaseController<JournalDto> {

    @Autowired
    private JournalService journalService;

    @Override
    @GetMapping("")
    public ResponseEntity<List<JournalDto>> list(){
        return new ResponseEntity<>(journalService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<JournalDto> retrieve(@PathVariable Long id){
        JournalDto journal = journalService.getJournalById(id);
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody JournalDto newJournal) {
        try {
            JournalDto journalDto = new JournalDto();
            journalDto.setTitle(newJournal.getTitle());
            journalDto.setContent(newJournal.getContent());
            journalDto.setUserId(newJournal.getUserId());
            journalService.saveJournal(journalDto);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PatchMapping("/{id}/")
    public ResponseEntity<JournalDto> partialUpdate(@PathVariable Long id, @RequestBody JournalDto updateJournal){
        JournalDto journal = journalService.updateJournalById(id, updateJournal);
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }
    @Override
    @DeleteMapping("/{id}/")
    public ResponseEntity<?> delete(@PathVariable Long id){
        boolean isDeleted = journalService.deleteJournalById(id);
        if (isDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
