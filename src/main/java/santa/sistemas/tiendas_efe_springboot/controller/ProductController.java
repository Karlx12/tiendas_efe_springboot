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

    @GetMapping({"/", "/index"})
    public String showHomePage(Model model) {
        model.addAttribute("products", productService.FindAll());
        return "product/index";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", productService.FindAll());
        return "product/productform";
    }
    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "product/productform";
        }
        if(product.getId() == null) {
            productService.Add(product);
        } else {
            productService.Update(product);
        }
        return "redirect:/product/index";
    }
    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        Product selectedProduct = productService.FindById(id);
        model.addAttribute("product", selectedProduct!=null?selectedProduct:new Product());
        return "product/productform";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model,@PathVariable("id") Long id) {
        productService.Delete(id);
        return "redirect:/product/index";
    }

}
