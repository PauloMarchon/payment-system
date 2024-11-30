package com.payments.user.domain.user;

import com.payments.user.domain.valueobjects.Email;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(Email email);
    void create(User user);
}