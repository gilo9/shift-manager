package mwa.giles.shiftmanager.service;

import mwa.giles.shiftmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public Long findEmployeeIdByEmail(String Email){
        return userRepository.findEmployeeIdByEmail(Email);
    }
}
