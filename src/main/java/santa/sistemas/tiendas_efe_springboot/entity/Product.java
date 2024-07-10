package santa.sistemas.tiendas_efe_springboot.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @Column(nullable = false)
    @NotBlank(message = "La marca no puede estar en blanco")
    private String brand;
    @Column(nullable = false)
    @DecimalMin(value ="0.1" ,message = "El valor no puede ser 0")
    private Float price;
    @Column(nullable = false)
    private Integer stock;
}
