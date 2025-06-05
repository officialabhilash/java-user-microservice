package com.example.user.groups.controllers;

import com.example.user.core.controllers.BaseController;
import com.example.user.groups.dto.GroupDto;
import com.example.user.groups.services.GroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Convention is : controller --> service --> repository


@RestController
@RequestMapping("/groups")
@Tag(name = "Group Management", description = "APIs for managing groups entries")
public class GroupController extends BaseController<GroupDto> {

    @Autowired
    private GroupService groupService;

    @Override
    @GetMapping("")
    public ResponseEntity<List<GroupDto>> list(){
        return new ResponseEntity<>(groupService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> retrieve(@PathVariable Long id){
        GroupDto journal = groupService.getGroupById(id);
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody GroupDto groupDto) {
        try {
            groupService.saveGroup(groupDto);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PatchMapping("/{id}/")
    public ResponseEntity<GroupDto> partialUpdate(@PathVariable Long id, @RequestBody GroupDto updateJournal){
        GroupDto journal = groupService.updateGroupById(id, updateJournal);
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }
    @Override
    @DeleteMapping("/{id}/")
    public ResponseEntity<?> delete(@PathVariable Long id){
        boolean isDeleted = groupService.deleteGroupById(id);
        if (isDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
