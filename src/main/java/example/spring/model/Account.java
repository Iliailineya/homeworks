package example.spring.model;

import example.spring.model.enams.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private  Long id;
    private String firstName;
    private String lastName;
    private String country;
    private LocalDate birthday;
    private Double balance;
    private Gender gender;
}

