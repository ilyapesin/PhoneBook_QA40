import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends TestBase{
//    WebDriver wd;
//    @BeforeMethod
//    public void init(){
//        wd=new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }



    @Test
    public void registrationPositiveTest(){
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        //fill login form
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("vasya_pupkin"+i+"@gmail.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Vp12345$");
        //click on button Registration
        wd.findElement(By.xpath("//button[2]")).click();
        //Assert
        // Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size()>=0);
        //Assert.assertTrue(wd.findElements(By.xpath("//button")).size()>0);
        pause(5000);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));
    }
    @Test
    public void registrationNegativeTest(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        //fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("vasya_pupkin@gmail.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Vp12345$");
        //click on button Registration
        wd.findElement(By.xpath("//button[2]")).click();
    }
    @Test
    public void registrationNegativeTestWrongEmail(){
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        String email="vasya_pupkingmail"+i+"gmail.com";
        String password="Vp12345$";
        openLoginForm();
        fillLoginForm(email, password);
        submitRegistrationForm();
    }
    @Test
    public void registrationNegativeTestWrongPassword(){
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        String email="vasya_pupkingmail"+i+"@gmail.com";
        String password="Vp12345$";
        openLoginForm();
        fillLoginForm(email, password);
        submitRegistrationForm();
    }

    @AfterMethod
    public  void  tearDown(){

    }
}
