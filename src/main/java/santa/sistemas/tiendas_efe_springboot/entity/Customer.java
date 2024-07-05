package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NotBlank(message="El nombre debe tener al menos una letra")
    @Size(min=1,max=40,message="El nombre debe tener entre 1 a 40 carácteres")
    private String name;
    @Column(nullable = false)
    @NotBlank(message="El Apellido debe tener al menos una letra")
    @Size(min=1,max=40,message="El Apellido debe tener entre 1 a 40 carácteres")
    private String lastname;

    @Column(nullable = false)
    @NotBlank(message = "El password debe tener al menos una letra")
    private String password;
    @Column(nullable = false)
    @NotBlank(message = "El dni no puede estar en blanco")
    @Size(min=8, max=8, message = "El DNI tiene 8 carácteres")
    private String dni;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past(message="El nacimiento debe ser anterior a la fecha actual")
    private Date birthday;
    @Column(length = 9, nullable = false)
    @NotBlank(message = "El celular no puede estar en blanco")
    @Size(min=9,max=9,message="El celular debe tener entre 2 y 35 caracteres")
    private String phone;
    @Column(length = 80)
    @NotBlank(message = "El eMail no puede estar en blanco")
    @Email(message="Debe ingresar un correo válido")
    private String eMail;






}
