package santa.sistemas.tiendas_efe_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import santa.sistemas.tiendas_efe_springboot.entity.User;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired private UserService userService;

    @GetMapping({"/index",""})
    public String index(Model model) {
        model.addAttribute("users", userService.FindAll());
        return "user/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user/userform";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("user") User user,
                       BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "user/userform";
        }
        if(user.getId() == null) {
            userService.Add(user);
        } else {
            userService.Update(user);
        }
        return "redirect:/user/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        User selectedUser = userService.FindById(id);
        model.addAttribute("user", selectedUser != null ? selectedUser : new User());
        return "user/userform";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        userService.Delete(id);
        return "redirect:/user/index";
    }

    // Método para editar la cuenta del usuario autenticado
    @GetMapping("/edit-account")
    public String editAccount(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        User loggedInUser = userService.findByUsername(username);
        if (loggedInUser == null) {
            return "redirect:/error"; // Redirigir a una página de error si el usuario no es encontrado
        }
    
        model.addAttribute("user", loggedInUser);
        return "user/editAccount"; // Asegúrate de que el nombre del archivo coincida
    }
   
    // Método para actualizar la cuenta del usuario autenticado
    @PostMapping("/update-account")
    public String updateAccount(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/editAccount"; // Vuelve a mostrar el formulario si hay errores
        }

        // Actualizar los datos del usuario autenticado
        userService.Update(user); // Guarda la información actualizada del usuario

        return "redirect:/user/edit-account?success"; // Redirige a la página de edición con un mensaje de éxito
    }
}

