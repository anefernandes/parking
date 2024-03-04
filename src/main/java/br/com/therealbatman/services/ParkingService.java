package br.com.therealbatman.services;

import br.com.therealbatman.domain.Employer;
import br.com.therealbatman.domain.ParkingRegistration;
import br.com.therealbatman.domain.Visitor;
import io.smallrye.common.constraint.NotNull;
import jakarta.validation.Valid;

import java.util.List;

public interface ParkingService {
    List<ParkingRegistration> listAllRegistration();
    ParkingRegistration findByLincensePlate(@NotNull String licensePlate);
    Employer findEmployerByLicensePlate(@NotNull String licensePlate);
    Visitor findVisitorByLicensePlate(@NotNull String licensePlate);
    void enrollEmployer(@Valid Employer employer);
    void enrollVisitor(@Valid Visitor visitor);
    void addEntrace(@Valid ParkingRegistration parkingRegistration);
    void addExit(@NotNull String licensePlate);
    Integer getAvailableParkingSpace();
}
