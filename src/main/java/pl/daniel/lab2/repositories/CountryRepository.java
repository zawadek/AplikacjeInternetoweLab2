package pl.daniel.lab2.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.daniel.lab2.entities.Country;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findByKontynent(String kontynent);
    List<Country> findByLiczbaLudnosciBetween(Double liczbaMin, Double liczbaMax);
    List<Country> findByPowierzchniaBetween(Double powMin, Double powMax);
}
