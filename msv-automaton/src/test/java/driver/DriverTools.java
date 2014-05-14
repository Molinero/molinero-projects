package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class DriverTools extends DriverConfigure {
    public void open(String url){
        getWebDriver().get(url);
    }

    public void click(By by){
        if(canFindAnElement(by)){
            getWebDriver().findElement(by).click();
            Log("Click on the element " + by);
        } else {
            Fail("Can't click the element " + by);
        }
    }

    public void setText(String text, By by){
        if(canFindAnElement(by)) {
            getWebDriver().findElement(by).clear();
            getWebDriver().findElement(by).sendKeys(text);
            Log("The text was set in " + by);
        } else {
            Fail("Can't set the text in " + by);
        }
    }

    public void selectOptionByName(By by, String optionName){
        if(canFindAnElement(by)){
            getWebDriver().findElement(by).sendKeys(optionName);
            Log("The option " + optionName + " was chosen.");
        } else {
            Fail("Can't choose set the option " + optionName);
        }
    }

    public Boolean canFindAnElement(By by){
        try{
            getWebDriver().findElement(by);
            return true;
        } catch (NotFoundException e){
            return false;
        }
    }

    public Integer getCountOfElements(By by){
        List<WebElement> elements = getWebDriver().findElements(by);
        return elements.size();
    }

    public void Log(String text){
        getLogger().writeToLogFile(text, "log");
    }

    public void Fail(String text){
        getLogger().writeToLogFile(text, "fail");
    }

    @BeforeMethod
    public void loginInApp(){
        if(!canFindAnElement(By.className("user_name"))) {
            Log("Need make login");

            open("http://molinero-cms.net/");

            if(canFindAnElement(By.name("AuthorizationForm"))) {
                Log("The page has been loaded.");
            }

            setText("molinero", By.name("userLogin"));
            setText("Molinero87", By.name("userPassword"));
            setText("Sledoput87", By.name("verificationCod"));
            click(By.className("SubmitButton"));

            if(canFindAnElement(By.tagName("body"))) {
                Log("Login - Ok");
            } else {
                Fail("Login - Fail");
            }
        } else {
            Log("No need make login");
        }
    }
}
