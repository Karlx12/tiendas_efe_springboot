package santa.sistemas.tiendas_efe_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santa.sistemas.tiendas_efe_springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Método personalizado para buscar por nombre de usuario
    User findByUsername(String username); // Cambia a findByEmail si usas email como identificador
}
