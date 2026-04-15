package mwa.giles.shiftmanager.service;

import mwa.giles.shiftmanager.model.User;
import mwa.giles.shiftmanager.model.userDTO;
import mwa.giles.shiftmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final PasswordEncoder passwordEncoder;

    public UserService(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findEmployeeByEmail(String Email){
        return userRepository.findEmployeeByEmail(Email);
    }

    public void registerUser(userDTO userDTO){
        logger.info("Registering user: {}", userDTO.getUsername());
        if (userRepository.existsByEmail(userDTO.getUsername())){
            throw new IllegalArgumentException("Username is already in use");
        }


       User user  = new User();
        user.setEmail(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()).getBytes());
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());

        logger.info("id:{} ",user.getEmployeeId());
       userRepository.save(user);
    }

}
