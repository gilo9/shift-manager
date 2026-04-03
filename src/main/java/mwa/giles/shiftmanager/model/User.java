package mwa.giles.shiftmanager.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import mwa.giles.shiftmanager.model.Shift;

@Getter
@Setter
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @GeneratedValue @Id
    private Long Employeeid;

    private String firstName;
    private String lastName;
    private String email;
    private byte[] password;
    @OneToMany
    private List<Shift> shifts;

}
