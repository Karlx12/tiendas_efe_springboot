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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping({"/index","/"})
    public String showHomePage(Model model) {
        model.addAttribute("products", productService.FindAll());
        return "product/index";
    }
    
    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/product_form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "product/product_form";
        }

        if (product.getId() != null && productService.FindById(product.getId()) != null) {
            productService.Update(product);
        } else {
            productService.Add(product);
        }
        return "redirect:/product/index";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        Product selectedProduct = productService.FindById(id);
        if (selectedProduct == null) {
            return "redirect:/product/index";
        }
        model.addAttribute("product", selectedProduct);
        return "product/product_form";
    }

    // Elimina un producto y redirige a la lista de productos
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.Delete(id);
        return "redirect:/product/";
    }

}
