package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import santa.sistemas.tiendas_efe_springboot.entity.Product;
import santa.sistemas.tiendas_efe_springboot.entity.Invoice;

import java.util.Map;

public interface CartService {
    void addToCart(Product product, int quantity);
    void removeFromCart(Product product);
    Map<Product, Integer> getCartItems();
    void clearCart();
    Invoice checkout();  // Método para procesar la compra y crear la factura
}
