package uz.utkirbek.jpaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Muallif: Utkirbek
 * Soat: 08:38:33
 * Kun: July 10, 2023, Monday
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

    @NotNull
    private String fullName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String address;
}
