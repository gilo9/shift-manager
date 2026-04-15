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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Long employeeId;

    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;
    private byte[] password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Shift> userShifts = new ArrayList<>();

}
