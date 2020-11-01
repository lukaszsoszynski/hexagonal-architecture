package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
class UserController {

    private final RestUserService restUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/users", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        restUserService.createUser(userDto);
    }

    @ResponseStatus(OK)
    @GetMapping(path = "/users/{userId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> findUserById(@PathVariable("userId") String userId) {
        return restUserService
                .findUserByEmail(userId)
                .map(user -> new ResponseEntity<>(user, OK))
                .orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }

}
