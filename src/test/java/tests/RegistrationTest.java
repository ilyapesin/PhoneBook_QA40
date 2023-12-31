package tests;

import manager.ProviderData;
import manager.TestNGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)

public class RegistrationTest extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preconditions(){
        if (app.getUser().isLogged()){
            app.getUser().logOut();

        }
    }
//    @Test
//    public void registrationPositiveTest(){
//        int i=(int)(System.currentTimeMillis()/1000)%3600;
//        String email="vasya_pupkin"+i+"@gmail.com";
//        String password="Vp12345$";
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(email, password);
//        app.getUser().submitRegistrationForm();
//        app.getUser().pause(3000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
//    }
    @Test(groups = {"smoke", "positive","regress"})
    public void registrationPositiveTestUser(){
        User user =new User()
                .withEmail("vasya_pupkin"+(int)(System.currentTimeMillis()/1000)%3600+"@gmail.com")
                .withPassword("Vp12345$")
                ;
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistrationForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }
    @Test(groups = {"smoke", "positive","regress"},dataProvider = "userDTOCSV",dataProviderClass = ProviderData.class)
    public void registrationPositiveTestUserCSV(User user){
        logger.info("Registration starts with email: "+user.getEmail()+" and password "+user.getPassword());
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistrationForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }
//    @Test
//    public void registrationNegativeTestWrongEmail(){
//        int i=(int)(System.currentTimeMillis()/1000)%3600;
//        String email="vasya_pupkingmail"+i+"gmail.com";
//        String password="Vp12345$";
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(email, password);
//        app.getUser().submitRegistrationForm();
//    }
    @Test(groups = {"regress", "negative"})
    public void registrationNegativeTestWrongEmailUser(){
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        User user =new User()
                .withEmail("vasya_pupkingmail"+i+"gmail.com")
                .withPassword("Vp12345$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistrationForm();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

//    @Test
//    public void registrationNegativeTestWrongPassword(){
//        int i=(int)(System.currentTimeMillis()/1000)%3600;
//        String email="vasya_pupkingmail"+i+"@gmail.com";
//        String password="Vp12345";
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(email, password);
//        app.getUser().submitRegistrationForm();
//    }
    @Test
    public void registrationNegativeTestWrongPasswordUser(){
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        User user =new User()
                .withEmail("vasya_pupkingmail"+i+"@gmail.com")
                .withPassword("Vp12345")
                ;

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistrationForm();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod
    public  void  tearDown(){

    }
}
