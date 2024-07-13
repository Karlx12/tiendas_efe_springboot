package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Payment_Method;
import santa.sistemas.tiendas_efe_springboot.repository.Payment_MethodRepository;

import java.util.List;

@Service
public class Payment_MethodServiceImpl implements Payment_MethodService{
    @Autowired
    private Payment_MethodRepository payment_MethodRepository;

    @Override
    public Payment_Method Add(Payment_Method payment_Method) {
        return payment_MethodRepository.save(payment_Method);
    }
    @Override
    public Payment_Method Update(Payment_Method payment_Method) {
        return payment_MethodRepository.save(payment_Method);
    }
    @Override
    public void Delete(Long id) {
        payment_MethodRepository.deleteById(id);
    }
    @Override
    public Payment_Method FindById(Long id) {
        return payment_MethodRepository.findById(id).orElse(null);
    }
    @Override
    public List<Payment_Method> FindAll() {
        return payment_MethodRepository.findAll();

    }

}
