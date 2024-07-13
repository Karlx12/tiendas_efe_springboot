package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.InvoiceItem;
import santa.sistemas.tiendas_efe_springboot.repository.InvoiceItemRepository;

import java.util.List;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {
    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public InvoiceItem Add(InvoiceItem invoiceItem) {
        return invoiceItemRepository.save(invoiceItem);
    }
    @Override
    public InvoiceItem Update(InvoiceItem invoiceItem) {
        return invoiceItemRepository.save(invoiceItem);
    }
    @Override
    public void Delete(Long id) {
        invoiceItemRepository.deleteById(id);
    }
    @Override
    public InvoiceItem FindById(Long id) {
        return invoiceItemRepository.findById(id).orElse(null);
    }
    @Override
    public List<InvoiceItem> FindAll() {
        return invoiceItemRepository.findAll();
    }

}
