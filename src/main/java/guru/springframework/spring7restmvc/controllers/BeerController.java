package guru.springframework.spring7restmvc.controllers;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.services.BeerService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BeerController {

    private final BeerService beerService;

    @PostMapping("/v1/beers")
    public ResponseEntity handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beers/" + savedBeer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
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
