package santa.sistemas.tiendas_efe_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import santa.sistemas.tiendas_efe_springboot.entity.User;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.UserService;
import santa.sistemas.tiendas_efe_springboot.entity.Role;

import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";  // Devuelve la vista "index.html" directamente
    }

    @GetMapping("/denied")
    public String denied() {
        return "error403";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @GetMapping("/populate")
    public String populate() {
        Role role_admin = new Role();
        role_admin.setName("ADMIN");
        Role role_user = new Role();
        role_user.setName("USER");

        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword(passwordEncoder.encode("admin"));  // Codifica la contraseña
        user1.addRole(role_admin);

        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword(passwordEncoder.encode("user"));  // Codifica la contraseña
        user2.addRole(role_user);

        userService.Add(user1);
        userService.Add(user2);

        return "redirect:/index";
    }

    @PostMapping("/signup")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup";  // Si hay errores de validación, volver a mostrar el formulario
        }

        // Codificar la contraseña antes de guardar el usuario
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Guardar el usuario en la base de datos
        userService.Add(user);

        // Redirigir al login después de un registro exitoso
        return "redirect:/login?registered";
    }
}
