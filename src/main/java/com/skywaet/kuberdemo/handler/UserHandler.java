package com.skywaet.kuberdemo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.skywaet.kuberdemo.model.User;
import com.skywaet.kuberdemo.service.UserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {
    private final UserService userService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.findAll(), User.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));

        return userService.findById(id).flatMap(user -> ServerResponse.ok()
                .body(user, User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<User> body = request.bodyToMono(User.class);
        return body.flatMap(user -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.create(user), User.class));
    }

}
