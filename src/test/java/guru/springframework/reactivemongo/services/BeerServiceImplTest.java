package guru.springframework.reactivemongo.services;

import guru.springframework.reactivemongo.domain.Beer;
import guru.springframework.reactivemongo.mappers.BeerMapper;
import guru.springframework.reactivemongo.model.BeerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerServiceImplTest {

    @Autowired
    BeerService beerService;

    @Autowired
    BeerMapper beerMapper;
    
    BeerDTO beerDTO;

    @BeforeEach
    void setUp() {
        beerDTO = beerMapper.beerToBeerDto(getTestBeer());
    }

    public static Beer getTestBeer() {
        return Beer.builder()
                .id("test-id")
                .beerName("Test Beer")
                .beerStyle("IPA")
                .upc("1234567890")
                .quantityOnHand(100)
                .price(new BigDecimal("9.99"))
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
    }

    @Test
    void getAllBeers() {
    }

    @Test
    void getBeerById() {
    }

    @Test
    void saveBeer() {
        AtomicBoolean saved = new AtomicBoolean(false);
        AtomicReference<BeerDTO> atomicBeerDTO = new AtomicReference<>();

        Mono<BeerDTO> savedBeer = beerService.saveBeer(Mono.just(beerDTO));
        savedBeer.subscribe(b -> {
            System.out.println(b);
            atomicBeerDTO.set(b);
            saved.set(true);
        });

        await().untilTrue(saved);
        BeerDTO persistedBeer = atomicBeerDTO.get();
        assertThat(persistedBeer).isNotNull();
        assertThat(persistedBeer.getId()).isNotNull();
        assertThat(persistedBeer.getBeerName()).isEqualTo("Test Beer");
        assertThat(persistedBeer.getBeerStyle()).isEqualTo("IPA");
        assertThat(persistedBeer.getUpc()).isEqualTo("1234567890");
        assertThat(persistedBeer.getQuantityOnHand()).isEqualTo(100);
        assertThat(persistedBeer.getPrice()).isEqualTo(new BigDecimal("9.99"));
        assertThat(persistedBeer.getCreatedDate()).isNotNull();
        assertThat(persistedBeer.getLastModifiedDate()).isNotNull();


    }

    @Test
    void updateBeer() {
    }

    @Test
    void deleteBeer() {
    }
}