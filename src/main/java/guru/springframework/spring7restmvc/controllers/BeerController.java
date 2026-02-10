package guru.springframework.spring7restmvc.controllers;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.services.BeerService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BeerController {

    private final BeerService beerService;

    @RequestMapping(value = "/v1/beer", method = RequestMethod.GET)
    public List<Beer> listBeers(@PathParam("beerId") UUID beerId) {
        log.debug("Controller: List Beers");
        return beerService.listBeers();
    }

    @RequestMapping(value = "/v1/beer/{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
        var beer = beerService.getBeerById(beerId);
        log.debug("Controller: Get Beer by id {}", beer);
        return beer;
    }

}
