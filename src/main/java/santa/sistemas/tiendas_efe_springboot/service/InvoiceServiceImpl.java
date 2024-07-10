package santa.sistemas.tiendas_efe_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Invoice;
import santa.sistemas.tiendas_efe_springboot.repository.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private SmsService smsService;

    @Override
    public Invoice Add(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
    @Override
    public Invoice Update(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
    @Override
    public void Delete(Long id) {
        invoiceRepository.deleteById(id);
    }
    @Override
    public Invoice FindById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }
    @Override
    public List<Invoice> FindAll() {
        return invoiceRepository.findAll();
    }
    public void processPayment(Long invoiceId) {
        Add(FindById(invoiceId));
        String toPhoneNumber = "customer_phone_number"; // Obtén el número de teléfono del cliente
        String message = "Tu pago ha sido procesado exitosamente. ID de la transacción: ...";
        smsService.sendSms(toPhoneNumber, message);
    }

}
