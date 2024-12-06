package com.payments.user.configuration.config;

import com.payments.user.domain.user.UserRepository;
import com.payments.user.infrastructure.dataproviders.postgres.user.PostgresUserRepository;
import com.payments.user.infrastructure.mapper.UserRowMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RepositoryConfig {

    @Bean
    public UserRepository postgresUserRepository(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        return new PostgresUserRepository(jdbcTemplate, userRowMapper);
    }
}