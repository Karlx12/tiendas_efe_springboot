package santa.sistemas.tiendas_efe_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired private RoleService roleService;
}
