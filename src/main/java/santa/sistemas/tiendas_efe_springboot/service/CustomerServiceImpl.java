package santa.sistemas.tiendas_efe_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Customer;
import santa.sistemas.tiendas_efe_springboot.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer Add(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public Customer FindById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    @Override
    public List<Customer> FindAll() {
        return customerRepository.findAll();
    }
    @Override
    public Customer Update(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public void Delete(Long id) {
        customerRepository.deleteById(id);
    }
}
