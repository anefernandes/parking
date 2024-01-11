package br.com.therealbatman.services.impl;

import br.com.therealbatman.domain.Employer;
import br.com.therealbatman.domain.ParkingRegistration;
import br.com.therealbatman.domain.Visitor;
import br.com.therealbatman.repository.EmployerRepository;
import br.com.therealbatman.repository.ParkingRegistrationRepository;
import br.com.therealbatman.repository.VisitorRepository;
import br.com.therealbatman.services.ParkingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ParkingServiceImpl implements ParkingService {

    @Inject
    EmployerRepository employerRepository;

    @Inject
    VisitorRepository visitorRepository;

    @Inject
    ParkingRegistrationRepository parkingRegistrationRepository;


    @Override
    public List<ParkingRegistration> listAllRegistration() {
        return parkingRegistrationRepository.findAll().list();
    }

    @Override
    public ParkingRegistration findByLincensePlate(String licensePlate) {
        return parkingRegistrationRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public Employer findEmployerByLicensePlate(String licensePlate) {
        return employerRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public Visitor findVisitorByLicensePlate(String licensePlate) {
        return visitorRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void enrollEmployer(Employer employer) {
        employerRepository.enrollEmployer(employer);
    }

    @Override
    public void enrollVisitor(Visitor visitor) {
        visitorRepository.enrollVisitor(visitor);
    }

    @Override
    public void addEntrace(ParkingRegistration parkingRegistration) {
        if (parkingRegistrationRepository.findAll().stream().count() > 11){
            throw new RuntimeException("Não há vagas disponíveis no momento, tente novamente mais tarde.");
        }
        parkingRegistrationRepository.entranceParking(parkingRegistration);
    }

    @Override
    public void addExit(String licensePlate) {
        parkingRegistrationRepository.exitParking(licensePlate);
    }

    @Override
    public Integer getAvailableParkingSpace() {
        return null;
    }
}
