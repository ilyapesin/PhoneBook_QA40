package tests;

import manager.TestNGListener;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNGListener.class)
public class LoginTests extends TestBase {
    @BeforeMethod
    public  void precondition(){
        if (app.getUser().isLogged()){
            app.getUser().logOut();

        }

    }

    @Test
    public void loginPositiveTest(){
       String email="vasya_pupkin@gmail.com";
       String password="Vp12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLoginForm();
        app.getUser().pause(3000);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
    @Test
    public void loginPositiveTestUser(){
        User user =new User()
                .withEmail("vasya_pupkin@gmail.com")
                .withPassword("Vp12345$")
                ;
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }
    @Test
    public void loginNegativeTestWrongEmail(){
       String email ="vasya_pupkingmailgmail.com";
       String password="Vp12345$";
       app.getUser().openLoginForm();
       app.getUser().fillLoginForm(email, password);
       app.getUser().submitLoginForm();
        Assert.assertTrue(app.getUser().isWarningFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());

    }@Test
    public void loginNegativeTestWrongEmailUser(){
        User user =new User()
               .withEmail("vasya_pupkingmail.com")
               .withPassword("Vp12345$")
                ;

       app.getUser().openLoginForm();
       app.getUser().fillLoginForm(user);
       app.getUser().submitLoginForm();

       Assert.assertTrue(app.getUser().isWarningFormatMessage());
       Assert.assertTrue(app.getUser().isAlertPresent());

    }
    @Test
    public void loginNegativeTestWrongPassword(){
        String email ="vasya_pupkin@gmailgmail.com";
        String password="Vp12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLoginForm();
        Assert.assertTrue(app.getUser().isWarningFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    } @Test
    public void loginNegativeTestWrongPasswordUser(){
        User user =new User()
              .withEmail("vasya_pupkin@gmailgmail.com")
              .withPassword("Vp12345")
                ;
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        Assert.assertTrue(app.getUser().isWarningFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod
    public  void  tearDown(){

    }
}
