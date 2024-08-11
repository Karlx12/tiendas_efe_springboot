package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Role;
import santa.sistemas.tiendas_efe_springboot.repository.RoleRepository;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role Add(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Role Update(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public void Delete(Long id) {
        roleRepository.deleteById(id);
    }
    @Override
    public Role FindById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
    @Override
    public List<Role> FindAll() {
        return roleRepository.findAll();
    }
}
