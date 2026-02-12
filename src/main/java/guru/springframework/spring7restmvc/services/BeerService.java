package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    Beer updateBeerById(UUID beerId, Beer beer);

    void deleteBeer(UUID beerId);

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);
}
