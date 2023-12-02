package tests;

import models.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
Logger logger= LoggerFactory.getLogger(AddNewContactTests.class);
    @BeforeMethod
    public void preconditions() {
        if (!app.getUser().isLogged()) {
            String email = "vasya_pupkin@gmail.com";
            String password = "Vp12345$";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLoginForm();
        }
    }
    @Test(invocationCount = 5)
    public void addNewContactPositive(){
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        Contact contact= Contact.builder()
                .name("John"+i)
                .lastName("Smith")
                .phone("0123456789"+i)
                .email("john"+i+"@gmail.com")
                .address("Tel-Aviv")
                .description("Fred")
                .build();
logger.info("Phone number is "+contact.getPhone());
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();
        app.getContact().pause(3000);
        Assert.assertTrue(app.getContact().isContactCreated(contact));
    }

}
