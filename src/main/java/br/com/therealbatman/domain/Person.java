package br.com.therealbatman.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public abstract class Person {
    @CPF
    @NotNull
    private String id;
    private String name;
    private String email;
    @NotNull
    private String licensePlate;
    private String phoneNumber;
}
