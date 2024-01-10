package br.com.therealbatman.domain;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@MongoEntity(collection= "visitor")
public class Visitor extends Person {
    @CPF
    private String id;
}
