package com.skywaet.kuberdemo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.skywaet.kuberdemo.model.User;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
