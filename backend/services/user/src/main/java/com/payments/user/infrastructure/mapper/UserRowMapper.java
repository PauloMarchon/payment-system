package com.payments.user.infrastructure.mapper;

import com.payments.user.domain.user.User;
import com.payments.user.domain.user.UserID;
import com.payments.user.domain.valueobjects.Email;
import com.payments.user.domain.valueobjects.IdentificationNumber;
import com.payments.user.domain.valueobjects.PhoneNumber;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.reconstruct(
                UserID.from(rs.getString("id")),
                rs.getString("full_name"),
                IdentificationNumber.of(rs.getString("identification_number")),
                Email.of(rs.getString("email")),
                rs.getObject("birth_date", LocalDate.class),
                PhoneNumber.of(rs.getString("phone_number")),
                rs.getObject("created_at", Instant.class)
        );
    }
}