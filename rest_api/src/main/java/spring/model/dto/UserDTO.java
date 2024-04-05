package spring.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.util.validation.UniqueUsername;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank
    @Size(min = 3, message = "size must be at least 3 symbols")
    @UniqueUsername(message = "user name is not unique")
    String username;
    @NotBlank
    String password;
    @NotBlank
    @Email
    String email;
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
}