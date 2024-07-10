package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "administrators")
@Data
@NoArgsConstructor
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message="El nombre debe tener al menos una letra")
    @Size(min=1,max=40,message="El nombre debe tener entre 1 a 40 carácteres")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "El password debe tener al menos una letra")
    private String password;
}
