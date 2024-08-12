package santa.sistemas.tiendas_efe_springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("user", selectedUser!=null?selectedUser:new User());
        return "user/userform";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        userService.Delete(id);
        return "redirect:/user/index";
    }



}
