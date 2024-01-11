package br.com.therealbatman.domain;

import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@MongoEntity(collection= "registration")
public class ParkingRegistration {
    @NotNull
    private String lincensePlate;
    @NotNull
    private String car;
    @NotNull
    private LocalDateTime entryDate;
    @NotNull
    private LocalTime entryHour;
    private LocalDateTime exitDate;
    private LocalTime exitHour;
}
