package project.ecomcfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityDto {
    Long id;
    String username;
    String email;
    String password;
    String phoneNumber;
}
