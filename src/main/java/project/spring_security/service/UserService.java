package project.spring_security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.spring_security.entity.Permission;
import project.spring_security.entity.User;
import project.spring_security.repository.PermissionRepository;
import project.spring_security.repository.UserRepository;
import project.spring_security.utility.UserUtility;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private PermissionRepository permissionRepository;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.permissionRepository = permissionRepository;
    }

    public Optional<User> save(User user) throws RuntimeException {

        if (UserUtility.isValidUsername(user.getUsername()) &&
                UserUtility.isValidPassword(user.getPassword())){

            Permission permission = permissionRepository.findByPermissionName("USER");
            user.setPermissions(Set.of(permission));

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    public User getByUserName(String username) {
       return userRepository.findByUsername(username);
    }
}
