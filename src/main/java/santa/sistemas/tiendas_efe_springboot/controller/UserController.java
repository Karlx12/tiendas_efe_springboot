package santa.sistemas.tiendas_efe_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user/denied")
    public String denied() {
        return "error403";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
