package santa.sistemas.tiendas_efe_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santa.sistemas.tiendas_efe_springboot.entity.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
