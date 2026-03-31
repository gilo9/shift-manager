package mwa.giles.shiftmanager.model;

import java.util.List;

import jakarta.persistence.*;
import mwa.giles.shiftmanager.model.Shift;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @GeneratedValue @Id
    private Long Employeeid;

    private String firstName;
    private String lastName;
    private String email;
    private byte[] password;
    @OneToMany
    private List<Shift> shifts;

    protected User() {}

    public User(String firstName, String lastName, String email, byte[] password) {}
}
