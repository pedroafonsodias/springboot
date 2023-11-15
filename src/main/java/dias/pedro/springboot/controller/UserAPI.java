package dias.pedro.springboot.controller;

import dias.pedro.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import postgres.tables.pojos.Users;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Deprecated use UserRouter instead
 */
@Deprecated
@RestController
public class UserAPI {
    @Autowired
    UserRepository repository;

    @GetMapping("user/{externalId}")
    public Mono<ResponseEntity<postgres.tables.pojos.Users>> getUserByExternalId(@PathVariable String externalId) {
        return repository.getUsersBy(externalId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    /*
        curl -v -H "Accept: text/event-stream" http://localhost:8080/user/stream
     */
    @GetMapping(value = "user/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Users> streamAllUsers() {
        return getAllUsers();

    }

    /*
        curl -v -H "Accept: application/x-ndjson" http://localhost:8080/user/stream2
     */
    @GetMapping(value = "user/stream2", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Users> streamAllUsers2() {
        return getAllUsers();
    }

    /**
     * Return all the Users in the database (initially configured from resources/data.sql)
     * with a delay of 5 seconds between Users retrieved.
     */
    private Flux<Users> getAllUsers() {
        return repository.getAllUsers()
                .limitRate(1)
                .doOnNext(el -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
