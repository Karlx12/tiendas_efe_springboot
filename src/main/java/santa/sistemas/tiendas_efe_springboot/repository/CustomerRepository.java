package santa.sistemas.tiendas_efe_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santa.sistemas.tiendas_efe_springboot.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
