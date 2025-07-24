package com.example.user.groups.services;

import com.example.user.groups.dto.GroupDto;
import com.example.user.groups.entities.GroupEntity;
import com.example.user.groups.repository.GroupRepository;
import com.example.user.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveGroup(GroupDto groupDto) throws PersistenceException {
        if (groupRepository.existsByName(groupDto.getName())) {
            throw new NonUniqueResultException("Group already exists");
        }
        GroupEntity groupEntity = GroupEntity.builder().
                name(groupDto.getName()).
                build();
        groupRepository.save(groupEntity);
    }

    public List<GroupDto> getAll() {

        return groupRepository.findAll().parallelStream().map(x -> GroupDto.builder().
                id(x.getId()).
                name(x.getName()).
                build()).collect(Collectors.toList());
    }

    public GroupDto getGroupById(Long id) {
        GroupEntity groupEntity = groupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return GroupDto.builder().
                id(groupEntity.getId()).
                name(groupEntity.getName()).
                build();
    }

    public GroupDto updateGroupById(Long id, GroupDto groupDto) {
        GroupEntity old = groupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        old.setName(groupDto.getName() != null && !groupDto.getName().equals("") ? groupDto.getName() : old.getName());
        groupRepository.save(old);
        return GroupDto.builder().
                id(old.getId()).
                name(old.getName()).
                build();
    }

    public boolean deleteGroupById(Long id) {
        boolean isGroupExists = groupRepository.existsById(id);
        if (isGroupExists) {
            groupRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
