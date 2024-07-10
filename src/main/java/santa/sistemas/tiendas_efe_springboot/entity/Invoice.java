package santa.sistemas.tiendas_efe_springboot.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name="invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE_TIME)
    private Date date;
    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<InvoiceItem> items;



}
