package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@Table(name = "payments")
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String paymentId;
    @Column(nullable = false)
    private String payerId;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Date paymentDate;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
