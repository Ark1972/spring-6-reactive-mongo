package guru.springframework.reactivemongo.services;

import guru.springframework.reactivemongo.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeerService {

    Flux<BeerDTO> getAllBeers(); // Retrieve all beer documents

    Mono<BeerDTO> getBeerById(String id); // Find beer by ID

    Mono<BeerDTO> saveBeer(Mono<BeerDTO> beer); // Save a new beer or update existing

    Mono<BeerDTO> updateBeer(String id, Mono<BeerDTO> beer); // Update an existing beer

    Mono<Void> deleteBeer(String id); // Delete by id
}