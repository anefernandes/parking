package br.com.therealbatman.services;

import br.com.therealbatman.domain.Employer;
import br.com.therealbatman.domain.ParkingRegistration;
import br.com.therealbatman.domain.Visitor;

import java.util.List;

public interface ParkingService {
    List<ParkingRegistration> listAllRegistration();
    ParkingRegistration findByLincensePlate(String licensePlate);
    Employer findEmployerByLicensePlate(String licensePlate);
    Visitor findVisitorByLicensePlate(String licensePlate);
    void enrollEmployer(Employer employer);
    void enrollVisitor(Visitor visitor);
    void addEntrace(ParkingRegistration parkingRegistration);
    void addExit(String licensePlate);
    Integer getAvailableParkingSpace();
}
