package santa.sistemas.tiendas_efe_springboot.controller;


import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import santa.sistemas.tiendas_efe_springboot.service.SmsService;

@Controller
public class SmsController {

    @Autowired
    private SmsService smsService;

    @GetMapping("/send-sms-form")
    public String showSmsForm() {
        return "smstest";
    }

    @PostMapping(path = "/send-sms")

    public String sendSms(@RequestParam String to, @RequestParam String message, Model model) {
        try {
            Message msg=smsService.sendSms(to, message);
            System.out.println(msg.getBody());
            System.out.println("Sucess");
            model.addAttribute("success", "SMS enviado exitosamente");
        } catch (Exception e) {

            model.addAttribute("error", "Error al enviar el SMS: " + e.getMessage());
            return "index";
        }

        return "smstest";
    }
}
