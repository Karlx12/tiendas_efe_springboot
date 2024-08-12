package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import santa.sistemas.tiendas_efe_springboot.entity.User;

import java.util.List;

public interface UserService extends iGenericService<User,Long>{
    public List<User> populateUsers(List<User> users);
}
