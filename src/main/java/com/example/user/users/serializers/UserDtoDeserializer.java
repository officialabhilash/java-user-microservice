package com.example.user.users.serializers;

import com.example.user.users.dto.UserDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserDtoDeserializer extends JsonDeserializer<UserDto> {

    @Override
    public UserDto deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        UserDto.UserDtoBuilder builder = UserDto.builder();

        if (node.has("id") && !node.get("id").isNull()) {
            builder.id(node.get("id").asLong());
        }
        if (node.has("username") && !node.get("username").isNull()) {
            builder.username(node.get("username").asText());
        }
        if (node.has("firstName") && !node.get("firstName").isNull()) {
            builder.firstName(node.get("firstName").asText());
        }
        if (node.has("lastName") && !node.get("lastName").isNull()) {
            builder.lastName(node.get("lastName").asText());
        }
        if (node.has("email") && !node.get("email").isNull()) {
            builder.email(node.get("email").asText());
        }
        if (node.has("password") && !node.get("password").isNull()) {
            builder.password(node.get("password").asText());
        }
        if (node.has("date") && !node.get("date").isNull()) {
            JsonNode dateNode = node.get("date");
            if (dateNode.isNumber()) {
                long timestamp = dateNode.asLong();
                LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
                builder.date(dateTime);
            } else if (dateNode.isTextual()) {
                // Optionally handle ISO string
                builder.date(LocalDateTime.parse(dateNode.asText()));
            }
        }
        return builder.build();
    }
} 