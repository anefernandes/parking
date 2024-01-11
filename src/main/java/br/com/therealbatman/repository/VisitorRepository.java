package br.com.therealbatman.repository;

import br.com.therealbatman.domain.Visitor;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VisitorRepository implements PanacheMongoRepository<Visitor> {
    public Visitor findByLicensePlate(String licensePlate){
        return find("licensePlate", licensePlate).firstResult();
    }
    public void enrollVisitor(Visitor visitor){
        persist(visitor);
    }
}
