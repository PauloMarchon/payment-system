package com.payments.user.configuration.resource;

import com.payments.user.application.usecases.user.create.CreateUserInput;
import com.payments.user.application.usecases.user.create.CreateUserUseCase;
import com.payments.user.domain.exception.NotificationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/users")
public class UserResource {
    private final CreateUserUseCase createUserUseCase;

    public UserResource(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@Valid @RequestBody RequestData requestData) {
        try {
            return ResponseEntity.ok(
                    createUserUseCase.execute(
                            CreateUserInput.with(
                                    requestData.fullName,
                                    requestData.identificationNumber,
                                    requestData.email,
                                    requestData.birthDate,
                                    requestData.phoneNumber
                            )
                    )
            );
        } catch (NotificationException e) {
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }

     record RequestData(
            @NotBlank @Size(min = 3, max = 100) String fullName,
            @NotBlank String identificationNumber,
            @NotBlank @Email String email,
            @NotNull @Past LocalDate birthDate,
            @NotBlank String phoneNumber
    ) { }
}