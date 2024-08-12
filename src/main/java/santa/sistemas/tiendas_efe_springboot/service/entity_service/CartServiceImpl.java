package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santa.sistemas.tiendas_efe_springboot.entity.Invoice;
import santa.sistemas.tiendas_efe_springboot.entity.InvoiceItem;
import santa.sistemas.tiendas_efe_springboot.entity.Product;
import santa.sistemas.tiendas_efe_springboot.repository.InvoiceRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    private final Map<Product, Integer> cart = new HashMap<>();

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void addToCart(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    @Override
    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    @Override
    public Map<Product, Integer> getCartItems() {
        return new HashMap<>(cart);
    }

    @Override
    public void clearCart() {
        cart.clear();
    }

    @Override
    public Invoice checkout() {
        Invoice invoice = new Invoice();
        invoice.setDate(new Date());
        invoice.setItems(new ArrayList<>());

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            InvoiceItem item = new InvoiceItem();
            item.setProduct(entry.getKey());
            item.setQuantity(entry.getValue());
            item.setInvoice(invoice);
            invoice.getItems().add(item);
        }

        Invoice savedInvoice = invoiceRepository.save(invoice);
        clearCart();  // Vaciar el carrito después de la compra
        return savedInvoice;
    }
}
