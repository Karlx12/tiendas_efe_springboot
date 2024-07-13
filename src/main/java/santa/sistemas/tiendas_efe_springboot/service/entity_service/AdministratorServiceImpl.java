package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Administrator;
import santa.sistemas.tiendas_efe_springboot.repository.AdministratorRepository;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Administrator Add(Administrator administrator) {
        return administratorRepository.save(administrator);
    }
    @Override
    public Administrator Update(Administrator administrator) {
        return administratorRepository.save(administrator);
    }
    @Override
    public void Delete(Long id) {
        administratorRepository.deleteById(id);
    }
    @Override
    public Administrator FindById(Long id) {
        return administratorRepository.findById(id).orElse(null);
    }
    @Override
    public List<Administrator> FindAll() {
        return administratorRepository.findAll();
    }

}
