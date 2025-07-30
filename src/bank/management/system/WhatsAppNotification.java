package bank.management.system;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsAppNotification {
    private static final String ACCOUNT_SID = "AC8ae30525ac357c7e848513588________"; // fill generate the twilio api 
    private static final String AUTH_TOKEN = "2166a9fed1721e1874bcae424___________";   // fill generate the twilio api 
    
 // Twilio numbers
    private static final String TWILIO_SMS_NUMBER = "+1217566_____"; 
    private static final String TWILIO_WHATSAPP_NUMBER = "whatsapp:+141552______";  //fill okay 

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
    
    // WhatsApp Message
    public static void sendWhatsApp(String toPhoneNumber, String messageText) {
    	try {
        Message message = Message.creator(
                new PhoneNumber("Whatsapp:" + toPhoneNumber),
                new PhoneNumber(TWILIO_WHATSAPP_NUMBER),
                messageText
        ).create();
        System.out.println("WhatsApp sent. SID: " + message.getSid());
    	} catch (Exception e) {
            System.out.println("Error sending WhatsApp message: " + e.getMessage());
    	}
    }
    
    // SMS Message
        public static void sendSMS(String toPhoneNumber, String messageBody) {
        try {
        Message message = Message.creator(
            new PhoneNumber(toPhoneNumber), // Twilio's sandbox number
            new PhoneNumber(TWILIO_SMS_NUMBER),         // Your verified WhatsApp number
            messageBody
        ).create();

        System.out.println("Message SID: " + message.getSid());
    } catch (Exception e) {
        System.out.println("Error sending WhatsApp message: " + e.getMessage());
      }
   }
}
