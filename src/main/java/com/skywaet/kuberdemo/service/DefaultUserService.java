package com.skywaet.kuberdemo.service;

import org.springframework.stereotype.Service;

import com.skywaet.kuberdemo.model.User;
import com.skywaet.kuberdemo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateById(Long id, User user) {
        return userRepository.findById(id).flatMap(old -> {
            user.setId(id);
            return userRepository.save(user);
        });
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return userRepository.deleteById(id);
    }

}