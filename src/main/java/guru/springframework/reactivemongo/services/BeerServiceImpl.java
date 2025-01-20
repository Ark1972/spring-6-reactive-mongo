package guru.springframework.reactivemongo.services;

import guru.springframework.reactivemongo.mappers.BeerMapper;
import guru.springframework.reactivemongo.model.BeerDTO;
import guru.springframework.reactivemongo.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    private final BeerMapper beerMapper;


    @Override
    public Flux<BeerDTO> getAllBeers() {
        return null;
    }

    @Override
    public Mono<BeerDTO> getBeerById(String id) {
        return null;
    }

    @Override
    public Mono<BeerDTO> saveBeer(Mono<BeerDTO> monoBeerDTO) {
        return monoBeerDTO.flatMap(beerDTO ->
            beerRepository.save(beerMapper.beerDtoToBeer(beerDTO))
            .map(beerMapper::beerToBeerDto)
        );
    }

    @Override
    public Mono<BeerDTO> updateBeer(String id, Mono<BeerDTO> beer) {
        return null;
    }

    @Override
    public Mono<Void> deleteBeer(String id) {
        return null;
    }
}
