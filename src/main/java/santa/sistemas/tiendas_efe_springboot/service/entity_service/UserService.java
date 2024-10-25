package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import java.util.List;

import santa.sistemas.tiendas_efe_springboot.entity.User;

public interface UserService extends iGenericService<User, Long> {
    List<User> populateUsers(List<User> users);

    // Nuevo método para buscar por nombre de usuario o email
    User findByUsername(String username);
}
