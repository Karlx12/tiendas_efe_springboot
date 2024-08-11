package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Admin;
import santa.sistemas.tiendas_efe_springboot.repository.AdminRepository;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin Add(Admin admin) {
        return adminRepository.save(admin);
    }
    @Override
    public Admin Update(Admin admin) {
        return adminRepository.save(admin);
    }
    @Override
    public void Delete(Long id) {
        adminRepository.deleteById(id);
    }
    @Override
    public Admin FindById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    @Override
    public List<Admin> FindAll() {
        return adminRepository.findAll();
    }

}
