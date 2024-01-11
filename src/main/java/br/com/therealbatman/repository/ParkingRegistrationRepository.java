package br.com.therealbatman.repository;

import br.com.therealbatman.domain.ParkingRegistration;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.time.LocalTime;

@ApplicationScoped
public class ParkingRegistrationRepository implements PanacheMongoRepository<ParkingRegistration> {
    public ParkingRegistration findByLicensePlate(String licensePlate){
        return find("licensePlate", licensePlate).firstResult();
    }

    public void entranceParking(ParkingRegistration parkingRegistration){
        parkingRegistration.setEntryDate(LocalDateTime.now());
        parkingRegistration.setEntryHour(LocalTime.now());
        persistOrUpdate(parkingRegistration);
    }

    public void exitParking(String licensePlate){
        ParkingRegistration parkingRegistration = find(licensePlate).firstResult();
        parkingRegistration.setExitDate(LocalDateTime.now());
        parkingRegistration.setExitHour(LocalTime.now());
        persistOrUpdate(parkingRegistration);
    }
}
