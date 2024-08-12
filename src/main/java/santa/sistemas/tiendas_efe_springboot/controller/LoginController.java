package santa.sistemas.tiendas_efe_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/product/index";
    }

    @GetMapping("/denied")
    public String denied() {
        return "error403";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
