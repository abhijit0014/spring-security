package project.spring_security.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import project.spring_security.entity.User;
import project.spring_security.service.UserService;
import project.spring_security.utility.JwtUtill;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class RootController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtUtill jwtUtill;

    public RootController(UserService userService, AuthenticationManager authenticationManager, JwtUtill jwtUtill) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtill = jwtUtill;
    }


    @PostMapping("/signup")
    public Optional<User> signup(@RequestBody @Valid User user) throws Exception {
        return userService.save(user);
    }

    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) throws Exception {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authenticate.isAuthenticated()){
            User tempUser = userService.getByUserName(user.getUsername());
            String jwtToken = jwtUtill.generateToken(tempUser.getUsername());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(jwtToken);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credential");
    }

    @RequestMapping("/")
    public String root(){
        return "working";
    }

}
