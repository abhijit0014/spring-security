package project.spring_security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.spring_security.entity.User;
import project.spring_security.repository.UserRepository;
import project.spring_security.utility.UserUtility;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> save(User user) throws RuntimeException {

        if (UserUtility.isValidUsername(user.getUsername()) &&
                UserUtility.isValidPassword(user.getPassword())){

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    public User getByUserName(String username) {
       return userRepository.findByUsername(username);
    }
}
