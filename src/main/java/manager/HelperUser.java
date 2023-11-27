package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){

        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }
    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);


    }
    public void fillLoginForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());

    }
    public void submitRegistrationForm(){

        click(By.xpath("//button[2]"));
    }
    public void submitLoginForm(){

        click(By.xpath("//button[1]"));
    }
    public void logOut(){

        click(By.xpath("//*[.='Sign Out']"));
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[.='Sign Out']"));

    }
    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert==null){return false;}
        wd.switchTo().alert();
        alert.accept();
        return true;
    }
    public boolean isWarningFormatMessage(){
        Alert alert = new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().contains("Wrong email or password");

    }

}
