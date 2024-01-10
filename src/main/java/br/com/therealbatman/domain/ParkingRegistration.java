package br.com.therealbatman.domain;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@MongoEntity(collection= "registration")
public class ParkingRegistration {
    private String lincensePlate;
    private String car;
    private LocalDateTime entryDate;
    private LocalTime entryHour;
    private LocalDateTime exitDate;
    private LocalTime exitHour;
}
