package santa.sistemas.tiendas_efe_springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import santa.sistemas.tiendas_efe_springboot.entity.Payment_Method;
import santa.sistemas.tiendas_efe_springboot.service.entity_service.Payment_MethodService;
@Controller
@RequestMapping("/payment_method")
public class Payment_MethodController {
    @Autowired private Payment_MethodService payment_methodService;

    @GetMapping({"/", "/index"})
    public String showHomePage(Model model) {
        model.addAttribute("payment_methods", payment_methodService.FindAll());
        return "payment_method/index";
    }
    @GetMapping("/add")
    public String addPayment_Method(Model model) {
        model.addAttribute("payment_method",new Payment_Method());
        return "payment_method/payment_methodform";
    }
    @PostMapping("/save")
    public String savePayment_Method(@Valid @ModelAttribute("payment_method") Payment_Method payment_method,
                                     BindingResult result,Model model) {
        if(result.hasErrors()) {
            return "payment_method/payment_methodform";
        }
        if(payment_method.getId() == null) {
            payment_methodService.Add(payment_method);
        } else {
            payment_methodService.Update(payment_method);
        }
        return "redirect:/payment_method/index";
    }
    @GetMapping("/edit/{id}")
    public String editPayment_Method(Model model, @PathVariable("id") Long id) {
        Payment_Method selectedPayment_Method = payment_methodService.FindById(id);
        model.addAttribute("payment_method", selectedPayment_Method!=null?selectedPayment_Method:new Payment_Method());
        return "payment_method/payment_methodform";
    }
    @GetMapping("/delete/{id}")
    public String deletePayment_Method(Model model, @PathVariable("id") Long id) {
        payment_methodService.Delete(id);
        return "redirect:/payment_method/index";
    }

}
