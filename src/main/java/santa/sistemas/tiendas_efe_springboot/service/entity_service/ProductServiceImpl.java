package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Product;
import santa.sistemas.tiendas_efe_springboot.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product Add(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Product Update(Product product) {
        return productRepository.save(product);
    }
    @Override
    public void Delete(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public Product FindById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public List<Product> FindAll() {
        return productRepository.findAll();
    }

}
