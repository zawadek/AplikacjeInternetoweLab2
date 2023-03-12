package pl.daniel.lab2.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.daniel.lab2.entities.Zadanie;

import java.util.List;

public interface ZadanieRepository extends CrudRepository<Zadanie, Long> {
    List<Zadanie> findByWykonane(Boolean isWykonane);
    List<Zadanie> findByKosztLessThan(Double koszt);
    List<Zadanie> findByKosztBetween(Double kosztMin, Double kosztMax);
}
