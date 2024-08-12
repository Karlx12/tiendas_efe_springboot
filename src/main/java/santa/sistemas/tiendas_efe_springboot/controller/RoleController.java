package santa.sistemas.tiendas_efe_springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import santa.sistemas.tiendas_efe_springboot.entity.Role;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired private RoleService roleService;

    @GetMapping({"/", "/index"})
    public String index() {
        return "role/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("role", new Role());
        return "role/roleform";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("role") Role role,
                       BindingResult result, Model model){
        if(result.hasErrors()){
            return "role/roleform";
        }
        if(role.getId() == null){
            roleService.Add(role);
        } else {
            roleService.Update(role);
        }

        return "redirect:/role/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        Role selectedRole = roleService.FindById(id);
        model.addAttribute("role", selectedRole!=null?selectedRole:new Role());
        return "role/roleform";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id){
        roleService.Delete(id);
        return "redirect:/role/index";
    }
}
