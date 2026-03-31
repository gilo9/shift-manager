package mwa.giles.shiftmanager.model;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mwa.giles.shiftmanager.model.Shift;

@Repository
public interface ShiftRepository extends CrudRepository<Shift, Long> {

    List<Shift> findByEmployeeId(Long employeeId);




}
