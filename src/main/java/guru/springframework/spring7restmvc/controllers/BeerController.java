package guru.springframework.spring7restmvc.controllers;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.model.Customer;
import guru.springframework.spring7restmvc.services.BeerService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BeerController {

    private final BeerService beerService;

    @PutMapping("/v1/beers/{beerId}")
    public ResponseEntity<?> updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer) {
        Beer updatedBear = beerService.updateBeerById(beerId, beer);
        return ResponseEntity.ok(updatedBear);
    }

    @PostMapping("/v1/beers")
    public ResponseEntity<?> createBeer(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);
        return  ResponseEntity.created(URI.create("/api/v1/beers/" + savedBeer.getId().toString())).build();
    }

    @DeleteMapping("/v1/beers/{beerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/v1/beers", method = RequestMethod.GET)
    public List<Beer> listBeers(@PathParam("beerId") UUID beerId) {
        log.debug("Controller: List Beers");
        return beerService.listBeers();
    }

    @RequestMapping(value = "/v1/beers/{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
        var beer = beerService.getBeerById(beerId);
        log.debug("Controller: Get Beer by id {}", beer);
        return beer;
    }

}
