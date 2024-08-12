package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private String id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "La descripción no puede estar en blanco")
    private String description;

    @Column(nullable = false)
    @NotBlank(message = "La marca no puede estar en blanco")
    private String brand;

    @Column(nullable = false)
    @DecimalMin(value = "0.1", message = "El valor no puede ser 0")
    private Float price;

    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer stock;

    public Product(String id, String name, String description, String brand, Float price, Date launchDate, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.launchDate = launchDate;
        this.stock = stock;
    }
}
