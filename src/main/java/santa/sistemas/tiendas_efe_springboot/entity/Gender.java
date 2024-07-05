package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="gender")
@NoArgsConstructor
public class Gender {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "El género no puede estar en blanco")
    private String gender;
}
