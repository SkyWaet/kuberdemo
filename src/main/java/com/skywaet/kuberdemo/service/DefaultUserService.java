package com.skywaet.kuberdemo.service;

import org.springframework.stereotype.Service;

import com.skywaet.kuberdemo.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DefaultUserService implements UserService {

    @Override
    public Flux<User> findAll() {
        return Flux.just(new User(1L, "test"));
    }

    @Override
    public Mono<User> findById(Long id) {
        return Mono.just(new User(1L, "test"));
    }

    @Override
    public Mono<User> create(User user) {
        user.setId(1L);
        return Mono.just(user);
    }

    @Override
    public Mono<User> updateById(Long id, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateById'");
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}