package santa.sistemas.tiendas_efe_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import santa.sistemas.tiendas_efe_springboot.entity.User;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.UserService;

import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

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
    public String signup(Model model) {
        model.addAttribute("user", new User());  // Añadir el objeto 'user' al modelo
        return "signup";
    }

    @PostMapping("/signup")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup";  // Si hay errores de validación, volver a mostrar el formulario
        }

        // Guardar el usuario en la base de datos sin encriptar la contraseña
        userService.Add(user);

        // Redirigir al login después de un registro exitoso
        return "redirect:/login?registered";
    }
}
