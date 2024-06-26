package com.teamproject1.scuoledevelhope.classes.user.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.user.dto.*;
import com.teamproject1.scuoledevelhope.classes.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @NoAuthorization
    @PostMapping("/login")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return userService.getJwtHeaderResponse();
    }

    @NoAuthorization
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public DashboardDto addUser(@Valid @RequestBody UserAdd user) {
        return userService.addUser(user);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/{username}")
    public UserDtoElement getByUsername(@Valid @PathVariable("username") String username) {
        return userService.getByUsername(username);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/all")
    public UserListDto getAll(@RequestParam int limit, int page) {
        return userService.getAll(limit, page);
    }

    @FloorLevelAuthorization(floorRole = "USER")
    @GetMapping("/dashboard")
    public DashboardDto dashboard(@RequestHeader("Authorization") String jwt) {
        return userService.getDashboard(jwt);
    }

    @FloorLevelAuthorization(floorRole = "USER")
    @PutMapping("/update")
    public DashboardDto update(@RequestHeader("Authorization") String jwt, @Valid @RequestBody UserAdd updatedUser) {
        return userService.updateUser(jwt, updatedUser);
    }

    @FloorLevelAuthorization(floorRole = "USER")
    @DeleteMapping("/delete")
    public DashboardDto delete(@RequestHeader("Authorization") String jwt) {
        return userService.delete(jwt);
    }
}
