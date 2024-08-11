package santa.sistemas.tiendas_efe_springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "administrators")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Admin extends User{

}
