package mwa.giles.shiftmanager.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userDTO {

    @NotBlank(message = "Email is Required")
    @Email(message = "Please enter a valid email address")
    private String username;

    @NotBlank(message = "Password is Required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @NotBlank(message = "Enter Your Last Name")
    private String lastname;

    @NotBlank(message = "Enter Your First Name")
    private String firstname;
}
