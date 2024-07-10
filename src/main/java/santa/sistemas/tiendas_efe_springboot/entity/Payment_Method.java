package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="payment_methods")
@NoArgsConstructor
public class Payment_Method {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "El método de pago no puede ser nulo")
    private String method;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCustomer",referencedColumnName = "id",nullable = false,foreignKey = @ForeignKey(name = "fk_customer_payment_method"))
    private Customer customer;
}
