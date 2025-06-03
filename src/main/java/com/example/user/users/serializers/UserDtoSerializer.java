package com.example.user.users.serializers;

import com.example.user.users.dto.UserDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;


public class UserDtoSerializer extends JsonSerializer<UserDto> {

    @Override
    public void serialize(UserDto userDto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        if (userDto.getId() != null) jsonGenerator.writeObjectField("id", userDto.getId());
        if (userDto.getUsername() != null) jsonGenerator.writeStringField("username", userDto.getUsername());
        if (userDto.getFirstName() != null) jsonGenerator.writeStringField("firstName", userDto.getFirstName());
        if (userDto.getLastName() != null) jsonGenerator.writeStringField("lastName", userDto.getLastName());
        // Always include email, even if null
        jsonGenerator.writeObjectField("email", userDto.getEmail());
//        if (userDto.getPassword() != null) jsonGenerator.writeStringField("password", userDto.getPassword());
        if (userDto.getDate() != null) jsonGenerator.writeObjectField("date", userDto.getDate());
        jsonGenerator.writeEndObject();
    }
}
