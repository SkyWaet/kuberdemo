package com.skywaet.kuberdemo.service;

import com.skywaet.kuberdemo.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> findAll();

    Mono<User> findById(Long id);

    Mono<User> create(User user);

    Mono<User> updateById(Long id, User user);

    Mono<Void> deleteById(Long id);
}
