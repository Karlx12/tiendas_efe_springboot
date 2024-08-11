package santa.sistemas.tiendas_efe_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
