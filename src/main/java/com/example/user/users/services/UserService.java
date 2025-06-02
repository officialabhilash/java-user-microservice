package com.example.user.users.services;

import com.example.user.users.dto.UserDto;
import com.example.user.users.entities.UserEntity;
import com.example.user.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // if the PasswordEncoder is not linted, don't worry, it is a bean.
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private String getHashedPassword(String rawPassword) {
        return this.passwordEncoder.encode(rawPassword);
    }

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public void createUser(UserDto userDto) throws ValidationException {
        boolean isUsernameTaken = userRepository.existsByUsername(userDto.getUsername());
        if (isUsernameTaken) {
            throw new ValidationException("Username already taken.");
        } else if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new ValidationException("Email address already Registered.");
        }
        UserEntity user = UserEntity.builder().
                email(userDto.getEmail()).
                username(userDto.getUsername()).
                date(LocalDateTime.now()).
                password(passwordEncoder.encode(userDto.getPassword())).
                build();
        userRepository.save(user);
    }

    public List<UserDto> getAll() {
        List<UserEntity> allUsers = userRepository.findAll();
        return allUsers.parallelStream().map(x -> UserDto.builder().
                id(x.getId()).
                username(x.getUsername()).
                firstName(x.getFirstName()).
                lastName(x.getLastName()).
                email(x.getEmail()).
                date(x.getDate()).
                build()).collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {

        UserEntity userEntity = userRepository.findById(id.toString()).orElseThrow(EntityNotFoundException::new);
        return UserDto.builder().
                username(userEntity.getUsername()).
                firstName(userEntity.getFirstName()).
                lastName(userEntity.getLastName()).
                email(userEntity.getEmail()).
                id(userEntity.getId()).
                date(userEntity.getDate()).
                build();
    }

    public UserDto updateUserById(Long id, UserDto userData) {
        UserEntity old = userRepository.findById(id.toString()).orElseThrow(EntityNotFoundException::new);
        // username and date can't change
        old.setUsername(!userData.getUsername().isBlank() ? userData.getUsername() : old.getUsername());
        old.setDate(userData.getDate() != null && !userData.getDate().toString().isBlank() ? userData.getDate() : LocalDateTime.now());

        // first name, last name can change
        old.setFirstName(userData.getFirstName() != null && !userData.getFirstName().isBlank() ? userData.getFirstName() : old.getFirstName());
        old.setLastName(userData.getLastName() != null && !userData.getLastName().isBlank() ? userData.getLastName() : old.getLastName());
        userRepository.save(old);
        return UserDto.builder().
                username(old.getUsername()).
                email(old.getEmail()).
                id(old.getId()).
                date(old.getDate()).
                build();
    }

    public boolean deleteUserById(Long id) {
        boolean existsById = userRepository.existsById(id.toString());
        if (existsById) {
            userRepository.deleteById(id.toString());
            return true;
        }
        return false;
    }
}
