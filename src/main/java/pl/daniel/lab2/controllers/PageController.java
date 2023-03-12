package pl.daniel.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.daniel.lab2.entities.Zadanie;
import pl.daniel.lab2.repositories.ZadanieRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class PageController {

    @Autowired
    ZadanieRepository repository;

    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    }

    @RequestMapping("/listaZadan")
    @ResponseBody
    public String listaZadan() {
        StringBuilder odp = new StringBuilder();

        double k=1000;
        boolean wyk=false;
        Zadanie z;
        for (int i=1;i<=10;i++){
            z = new Zadanie();
            z.setNazwa("zadanie "+i);
            z.setOpis("Opis czynnosci do wykonania w zadaniu "+i);
            z.setKoszt(k);
            z.setWykonane(wyk);
            wyk=!wyk;
            k+=200.50;
            repository.save(z);
        }

        for(Zadanie zad: repository.findAll()) {
            odp.append(zad).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping(path = "delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Optional<Zadanie> z = repository.findById(id);
        StringBuilder odp = new StringBuilder();
        odp.append("Zadanie do usuniecia ").append(z).append("<br>");
        repository.delete(z.get());

        for(Zadanie zad: repository.findAll()) {
            odp.append(zad).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping(path = "wykonane/{isWykonane}")
    @ResponseBody
    public String getWykonane(@PathVariable Boolean isWykonane) {
        List<Zadanie> zList = repository.findByWykonane(isWykonane);
        StringBuilder odp = new StringBuilder();
        odp.append("Znalezione zadania:").append("<br>");

        for(Zadanie zad: zList) {
            odp.append(zad).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping(path = "kosztLessThan/{koszt}")
    @ResponseBody
    public String getKosztLessThan(@PathVariable double koszt) {
        List<Zadanie> zList = repository.findByKosztLessThan(koszt);
        StringBuilder odp = new StringBuilder();
        odp.append("Znalezione zadania:").append("<br>");

        for(Zadanie zad: zList) {
            odp.append(zad).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping(path = "kosztBetween/{kosztMin}/{kosztMax}")
    @ResponseBody
    public String getKosztBetween(@PathVariable double kosztMin, @PathVariable double kosztMax) {
        List<Zadanie> zList = repository.findByKosztBetween(kosztMin, kosztMax);
        StringBuilder odp = new StringBuilder();
        odp.append("Znalezione zadania:").append("<br>");

        for(Zadanie zad: zList) {
            odp.append(zad).append("<br>");
        }
        return odp.toString();
    }
}
