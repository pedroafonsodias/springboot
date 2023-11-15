package dias.pedro.springboot.users;

import dias.pedro.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import postgres.tables.pojos.Users;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {
    @Autowired
    UserRepository repository;

    public Mono<ServerResponse> streamAllUsers(final ServerRequest serverRequest) {
        return ok()
                .header("APIVersion", "v1")
                .body(getAllUsers(), Users.class);
    }

    public Mono<ServerResponse> streamAllUsers2(final ServerRequest serverRequest) {
        return ok()
                .header("APIVersion", "v2")
                .contentType(MediaType.valueOf(MediaType.APPLICATION_STREAM_JSON_VALUE))
                .body(getAllUsers(), Users.class);
    }

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
