package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    /*WebDriver wd;
    @BeforeMethod
    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }*/
    @BeforeMethod
    public  void precondition(){
        if (app.getUser().isLogged()){
            app.getUser().logOut();
        }

    }

//    @Test
//    public void loginPositiveTest() {
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        //fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("vasya_pupkin@gmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Vp12345$");
//        //click on button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//        //Assert
//        // Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size()>=0);
//        pause(5000);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size()>0);
//
//    }
    @Test
    public void loginPositiveTestBase(){
       String email="vasya_pupkin@gmail.com";
       String password="Vp12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLoginForm();
        app.getUser().pause(3000);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
//   @Test
//    public void loginNegativeTestWrongEmail(){
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        //fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("vasya_pupkingmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Vp12345$");
//        //click on button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//    }
//    @Test
//    public void loginNegativeTestWrongPassword(){
//        String email="vasya_pupkin@gmail.com";
//        String password="Vp12345";
//        openLoginForm();
//        fillLoginForm(email, password);
//        submitLoginForm();
//
//
//    }

    @AfterMethod
    public  void  tearDown(){

    }
}
