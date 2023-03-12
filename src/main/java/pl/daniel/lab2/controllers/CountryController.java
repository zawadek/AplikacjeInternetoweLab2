package pl.daniel.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.daniel.lab2.entities.Country;
import pl.daniel.lab2.repositories.CountryRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    CountryRepository repository;

    @RequestMapping("country/create")
    @ResponseBody
    public String createCountries() {
        List<Country> cList = new ArrayList<Country>();
        StringBuilder odp = new StringBuilder();
        List<String> names = getCountryNames();
        List<String> continents = getCountryContinents();
        List<Double> population = getCountryPopulation();
        List<Double> surface = getCountrySurface();

        for (int i = 0; i < names.size(); i++) {
            Country con = new Country();
            con.setNazwa(names.get(i));
            con.setKontynent(continents.get(i));
            con.setLiczbaLudnosci(population.get(i));
            con.setPowierzchnia(surface.get(i));
            cList.add(con);
            odp.append(con).append("<br>");
        }
        repository.saveAll(cList);
        return odp.toString();
    }

    @RequestMapping("/country/{kontynent}")
    @ResponseBody
    public String getCountryByKontynent(@PathVariable String kontynent) {
        List<Country> cList = repository.findByKontynent(kontynent);
        StringBuilder odp = new StringBuilder();
        odp.append("Znalezione kraje:").append("<br>");

        for(Country con: cList) {
            odp.append(con).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/country/ludnoscBetw/{min}/{max}")
    @ResponseBody
    public String getCountryByPopulationInBetween(@PathVariable Double min, @PathVariable Double max) {
        List<Country> cList = repository.findByLiczbaLudnosciBetween(min, max);
        StringBuilder odp = new StringBuilder();
        odp.append("Znalezione kraje:").append("<br>");

        for(Country con: cList) {
            odp.append(con).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/country/powBetw/{min}/{max}")
    @ResponseBody
    public String getCountryBySurfaceInBetween(@PathVariable Double min, @PathVariable Double max) {
        List<Country> cList = repository.findByPowierzchniaBetween(min, max);
        StringBuilder odp = new StringBuilder();
        odp.append("Znalezione kraje:").append("<br>");

        for(Country con: cList) {
            odp.append(con).append("<br>");
        }
        return odp.toString();
    }

    private List<String> getCountryNames() {
        List<String> countries = new ArrayList<>();
        countries.add("Canada");
        countries.add("United States");
        countries.add("Mexico");
        countries.add("Brazil");
        countries.add("Argentina");
        countries.add("France");
        countries.add("Germany");
        countries.add("Spain");
        countries.add("Russia");
        countries.add("China");
        return countries;
    }

    private List<String> getCountryContinents() {
        List<String> continents = new ArrayList<>();
        continents.add("North America");
        continents.add("North America");
        continents.add("North America");
        continents.add("South America");
        continents.add("South America");
        continents.add("Europe");
        continents.add("Europe");
        continents.add("Europe");
        continents.add("Asia");
        continents.add("Asia");
        return continents;
    }

    private List<Double> getCountryPopulation() {
        List<Double> populations = new ArrayList<>();
        populations.add(37.59);
        populations.add(328.2);
        populations.add(126.2);
        populations.add(213.99);
        populations.add(45.2);
        populations.add(66.99);
        populations.add(83.1);
        populations.add(47.43);
        populations.add(144.5);
        populations.add(1408.03);
        return populations;
    }

    private List<Double> getCountrySurface() {
        List<Double> surfaces = new ArrayList<>();
        surfaces.add(9984670.0);
        surfaces.add(9833520.0);
        surfaces.add(1964375.0);
        surfaces.add(8515767.0);
        surfaces.add(2780400.0);
        surfaces.add(643801.0);
        surfaces.add(357114.0);
        surfaces.add(505990.0);
        surfaces.add(17125242.0);
        surfaces.add(9596960.0);
        return surfaces;
    }
}
