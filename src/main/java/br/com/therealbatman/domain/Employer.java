package br.com.therealbatman.domain;

import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@MongoEntity(collection= "employer")
public class Employer extends Person {
    @NotNull
    private String credencialNumber;
}
