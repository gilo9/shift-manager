package mwa.giles.shiftmanager.repository;
import java.util.List;

import mwa.giles.shiftmanager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mwa.giles.shiftmanager.model.Shift;

@Repository
public interface ShiftRepository extends CrudRepository<Shift, Long> {

    List<Shift> getAllByUser(User user);
}
