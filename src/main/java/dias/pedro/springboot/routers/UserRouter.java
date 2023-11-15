package dias.pedro.springboot.routers;

import dias.pedro.springboot.users.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRouter {

    private static final String V1 = "/v1";
    private static final String V2 = "/v2";

    private static final String USERS = "/users";


    @Bean
    RouterFunction<ServerResponse> getAllUsers(final UserHandler userHandler) {
        return route().nest(accept(APPLICATION_JSON), builder -> {
            builder.path(V1, v1Builder -> v1Builder.path(USERS,
                            userBuilder -> userBuilder.GET(userHandler::streamAllUsers).build()).build())
                    .path(V2, v2Builder -> v2Builder.path(USERS,
                            userBuilderV2 -> userBuilderV2.GET(userHandler::streamAllUsers2).build()).build())

                    .build();
        }).build();
    }
}
