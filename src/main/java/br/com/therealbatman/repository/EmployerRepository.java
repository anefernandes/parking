package br.com.therealbatman.repository;

import br.com.therealbatman.domain.Employer;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployerRepository implements PanacheMongoRepository<Employer> {
    public Employer findByLicensePlate(String licensePlate){
        return find("licensePlate", licensePlate).firstResult();
    }

    public void enrollEmployer(Employer employer){
        persist(employer);
    }
}
