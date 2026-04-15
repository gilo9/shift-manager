package mwa.giles.shiftmanager.service;

import mwa.giles.shiftmanager.model.Shift;
import mwa.giles.shiftmanager.model.User;
import mwa.giles.shiftmanager.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    public List<Shift> shiftByUser(Long EmployeeId) {
        return shiftRepository.findByUser_EmployeeId(EmployeeId);
    }
    public List<Shift> shiftByUser(User user) {
        return shiftRepository.findByUser(user);
    }

}
