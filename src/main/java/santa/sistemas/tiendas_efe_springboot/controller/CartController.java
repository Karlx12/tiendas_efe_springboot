package santa.sistemas.tiendas_efe_springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import santa.sistemas.tiendas_efe_springboot.entity.Product;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.CartService;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "cart/view";  // Asegúrate de que esta plantilla existe en el directorio correcto
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") String productId, HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        Product product = productService.FindById(productId);
        if (product != null) {
            cart.add(product);
        }

        model.addAttribute("cart", cart);
        return "redirect:/cart/view";
    }

    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        model.addAttribute("cart", cart);
        return "cart/view"; // Debes crear la vista 'view.html' en la carpeta 'templates/cart'
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam("productId") String productId) {
        Product product = productService.FindById(productId);
        if (product != null) {
            cartService.removeFromCart(product);
        }
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout() {
        cartService.checkout();  // Procesa la compra
        return "redirect:/";  // Redirige al inicio después de la compra
    }
}
