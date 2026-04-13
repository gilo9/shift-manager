package mwa.giles.shiftmanager.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import mwa.giles.shiftmanager.model.Shift;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="EMPLOYEES")
public class User {
    @GeneratedValue @Id
    private Long EmployeeId;

    private String firstName;
    private String lastName;
    private String Email;
    private byte[] Password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @Builder.Default
    private List<Shift> userShifts = new ArrayList<>();

}
