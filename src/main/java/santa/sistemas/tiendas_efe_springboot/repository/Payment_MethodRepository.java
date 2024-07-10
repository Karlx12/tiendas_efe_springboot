package santa.sistemas.tiendas_efe_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santa.sistemas.tiendas_efe_springboot.entity.Payment_Method;

public interface Payment_MethodRepository extends JpaRepository<Payment_Method, Long> {
}
