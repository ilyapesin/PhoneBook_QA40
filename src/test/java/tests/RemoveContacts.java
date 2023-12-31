package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContacts extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        if (!app.getUser().isLogged()) {
            String email = "vasya_pupkin@gmail.com";
            String password = "Vp12345$";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLoginForm();
        }
    }
    @Test(alwaysRun = true)
    public void removeOneContact(){
        if(app.getContact().isNoContact()) {
            return;
        }
        app.getContact().removeContact();

        Assert.assertEquals(1,app.getContact().removeContact() );
    }
    @Test
    public void removeAllContact(){
        app.getContact().removeContactAll();
        Assert.assertTrue(app.getContact().isNoContact());

    }
    @AfterMethod(alwaysRun = true)
    public void postcondition(){
        if(app.getUser().isLogged())
        {
            app.getUser().logOut();
        }
    }
}
