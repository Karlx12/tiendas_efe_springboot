package santa.sistemas.tiendas_efe_springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import santa.sistemas.tiendas_efe_springboot.entity.Product;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("products", productService.FindAll());
        return "index";
    }
    
    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/productform";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "product/productform";
        }
        productService.Add(product);
        return "redirect:/product/index";
    }

 // Muestra el formulario para editar un producto existente
    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") String id) {
        Product selectedProduct = productService.FindById(id);
        model.addAttribute("product", selectedProduct != null ? selectedProduct : new Product());
        return "product/productform";
    }

    // Elimina un producto y redirige a la lista de productos
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        productService.Delete(id);
        return "redirect:/product/";
    }

}
