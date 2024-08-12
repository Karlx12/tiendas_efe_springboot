package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.User;
import santa.sistemas.tiendas_efe_springboot.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User Add(User user) {
        return userRepository.save(user);
    }
    @Override
    public User Update(User user) {
        return userRepository.save(user);
    }
    @Override
    public void Delete(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User FindById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public List<User> FindAll() {
        return userRepository.findAll();
    }
    @Override
    public List<User> populateUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

}
