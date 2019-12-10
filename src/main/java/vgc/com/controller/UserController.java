package vgc.com.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import vgc.com.entities.User;
import vgc.com.model.UserNameProfile;
import vgc.com.service.UserService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;

@RestController
@Api("User API")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get List User")
    @GetMapping(value = "/user")
    public ResponseEntity<?> getUser(){
        return userService.getUser();
    }

    @ApiOperation(value = "Get a User Full Name")
    @GetMapping(value = "/user/{id}/name")
    public ResponseEntity<?> getUserFullName(@PathVariable int id){
        return userService.getUserFullName(id);
    }

    @ApiOperation(value = "Get a User's City")
    @GetMapping(value = "/user/{id}/city")
    public ResponseEntity<?> getUserCity(@PathVariable int id){
        return userService.getUserCity(id);
    }

    @ApiOperation(value = "Get a User's Username")
    @GetMapping(value = "/user/{id}/username")
    public ResponseEntity<?> getUserName(@PathVariable int id){
        return userService.getUserName(id);
    }

    @ApiOperation(value = "Get User's Phone")
    @GetMapping(value = "/user/{id}/phone")
    public ResponseEntity<?> getUserPhone(@PathVariable int id){
        return userService.getUserPhone(id);
    }

    @ApiOperation(value = "Get User's Birth Day")
    @GetMapping(value = "/user/{id}/birth")
    public ResponseEntity<?> getUserBirthDay(@PathVariable int id){
        return userService.getUserBirthDay(id);
    }

    @ApiOperation(value = "Get User's Email")
    @GetMapping(value = "/user/{id}/email")
    public ResponseEntity<?> getUserEmail(@PathVariable int id){
        return userService.getUserEmail(id);
    }

    @ApiOperation(value = "Get User's Point")
    @GetMapping(value = "/user/{id}/point")
    public ResponseEntity<?> getUserPoint(@PathVariable int id){
        return userService.getUserPoint(id);
    }

    @ApiOperation(value = "Register")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @ApiOperation(value = "Update user")
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(Authentication authentication, @Valid @RequestBody UserNameProfile user) throws ParseException {
        return ResponseEntity.ok(userService.updateUser(authentication, user));
    }

    @ApiOperation(value = "Get token login")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody HashMap<String, String> request){
        return ResponseEntity.ok(userService.loginUser(request.get("username"), request.get("password")));
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfo(Authentication authentication){
        return ResponseEntity.ok(userService.getInfo(authentication));
    }
}
