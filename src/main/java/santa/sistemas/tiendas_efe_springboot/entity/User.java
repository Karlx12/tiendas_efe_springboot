package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "El nombre debe tener al menos una letra")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "El password debe tener al menos una letra")
    private String password;
    @Column(nullable = false)
    private String rol;
    @Column(nullable = false)
    private int state;
    public User(String name, String password, String rol, int state) {
        super();
        this.name = name;
        this.password = password;
        this.rol = rol;
        this.state = state;
    }



}

