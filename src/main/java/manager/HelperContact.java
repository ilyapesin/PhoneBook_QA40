package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class HelperContact extends HelperBase{

    Logger logger= LoggerFactory.getLogger(HelperContact.class);
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    public void openContactForm(){

        wd.findElement(By.xpath("//*[.='ADD']")).click();
    }
    public void fillContactForm(Contact contact){
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }
    public void submitContactForm(){

        click(By.xpath("//b[.='Save']"));
    }

    public boolean isContactCreated(Contact contact) {
        String phone = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).getText();
        return phone.equals(contact.getPhone());
    }
    public int removeContact() {
        int beforeContact=countContact();
        logger.info("Before contact ="+beforeContact);
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        click(By.xpath("//button[.='Remove']"));
        pause(500);
        int afterContact=countContact();
        logger.info("After contact ="+afterContact);
        return beforeContact-afterContact;
    }

    private int countContact() {

        return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size();
    }
    public void removeContactAll() {
        while(wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size()>0) {
            removeContact();
        }
    }
    public boolean isNoContact(){
       return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size()==0;
    }


}

