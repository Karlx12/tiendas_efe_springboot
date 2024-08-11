package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "customers")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Customer extends User{

    @Column(nullable = false)
    @NotBlank(message="El nombre debe tener al menos una letra")
    @Size(min=1,max=40,message="El nombre debe tener entre 1 a 40 carácteres")
    private String name;
    @Column(nullable = false)
    @NotBlank(message="El Apellido debe tener al menos una letra")
    @Size(min=1,max=40,message="El Apellido debe tener entre 1 a 40 carácteres")
    private String lastname;


    @Column(nullable = false,length = 8)
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
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private Gender gender;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private Payment_Method payment_method;






}
