package br.com.therealbatman.domain;

import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@MongoEntity(collection= "visitor")
public class Visitor extends Person {
}
