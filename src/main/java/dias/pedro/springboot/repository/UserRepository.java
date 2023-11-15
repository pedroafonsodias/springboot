package dias.pedro.springboot.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import postgres.tables.Users;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository  {

    @Autowired
    DSLContext dsl;

    public Mono<postgres.tables.pojos.Users> getUsersBy(String externalId) {
        return Mono.justOrEmpty(
                dsl.selectFrom(postgres.tables.Users.USERS)
                        .where(Users.USERS.EXTERNAL_ID.equalIgnoreCase(externalId))
                        .fetchSingleInto(postgres.tables.pojos.Users.class)
        );
    }

    public Flux<postgres.tables.pojos.Users> getAllUsers() {
        return Flux.fromIterable(dsl.selectFrom(Users.USERS).fetchInto(postgres.tables.pojos.Users.class));
    }
}
