package com.payments.user.infrastructure.dataproviders.postgres.user;

import com.payments.user.domain.user.User;
import com.payments.user.domain.user.UserRepository;
import com.payments.user.domain.valueobjects.Email;
import com.payments.user.infrastructure.mapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class PostgresUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

    public PostgresUserRepository(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        var sql = """
                SELECT *
                FROM users u
                WHERE u.email = :email
                """;
        return jdbcTemplate.query(sql, userRowMapper, email.getValue())
                .stream()
                .findFirst();
    }

    @Override
    public void create(User user) {
        var sql = """
                INSERT INTO users(id, full_name, identification_number, email, birth_date, phone_number, created_at)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(
                sql,
                user.getId().getValue(),
                user.getFullName(),
                user.getIdentificationNumber().getValue(),
                user.getEmail().getValue(),
                user.getBirthDate(),
                user.getPhoneNumber().getValue(),
                user.getCreatedAt()
        );
    }
}