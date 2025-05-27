package it.gp.db_relations.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO {
    private Long id;
    private String address;
    private String phoneNumber;
    private Long userId;
}
