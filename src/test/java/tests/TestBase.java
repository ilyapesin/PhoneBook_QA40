package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

//    WebDriver wd;
    @BeforeSuite
    public void setApp(){
        app.init();
    }
    @AfterSuite
    public  void  stop(){
       app.tearDown();
    }
//    public void click(By locator){
//
//        wd.findElement(locator).click();
//    }
//    public void type(By locator, String text){
//
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//
//    }
//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public void openLoginForm(){
//
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//    }
//    public void fillLoginForm(String email, String password){
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//
//
//    }
//    public void submitRegistrationForm(){
//
//        click(By.xpath("//button[2]"));
//    }
//    public void submitLoginForm(){
//
//        click(By.xpath("//button[1]"));
//    }

//    public boolean isElementPresent(By locator){
//
//        return wd.findElements(locator).size()>0;
//
//
//    }
//    public void logOut(){
//        click(By.xpath("//*[.='Sign Out']"));
//    }
//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//*[.='Sign Out']"));
//
//    }

}