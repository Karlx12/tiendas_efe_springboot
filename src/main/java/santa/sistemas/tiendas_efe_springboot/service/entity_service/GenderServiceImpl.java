package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Gender;
import santa.sistemas.tiendas_efe_springboot.repository.GenderRepository;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService{
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public Gender Add(Gender gender) {
        return genderRepository.save(gender);
    }
    @Override
    public Gender Update(Gender gender) {
        return genderRepository.save(gender);
    }
    @Override
    public void Delete(Long id) {
        genderRepository.deleteById(id);
    }
    @Override
    public Gender FindById(Long id) {
        return genderRepository.findById(id).orElse(null);
    }
    @Override
    public List<Gender> FindAll() {
        return genderRepository.findAll();
    }

}
