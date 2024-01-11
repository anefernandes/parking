package br.com.therealbatman.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Person {
    private String name;
    private String email;
    @NotNull
    private String licensePlate;
    private String phoneNumber;
}
