package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="genders")
@NoArgsConstructor
public class Gender {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "El género no puede estar en blanco")
    private String gender;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCustomer",referencedColumnName = "id",nullable = false,foreignKey = @ForeignKey(name = "fk_customer_gender"))
    private Customer customer;

}
