package br.com.therealbatman.domain;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;

@Data
@MongoEntity(collection= "employer")
public class Employer extends Person {
    private String credencialNumber;
}
