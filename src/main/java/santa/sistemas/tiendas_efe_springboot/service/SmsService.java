package santa.sistemas.tiendas_efe_springboot.service;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;
    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public Message sendSms(String toPhoneNumber, String message) {
        initTwilio();
        Message msg=Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                message
        ).create();
        System.out.println(msg.getBody());
        return msg;
    }
}

