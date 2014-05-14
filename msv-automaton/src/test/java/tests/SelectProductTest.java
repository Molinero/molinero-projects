package tests;

import driver.DriverTools;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SelectProductTest extends DriverTools {

    @Test(dataProvider = "product", dataProviderClass = TestDataProvider.class)
    public void calcTheItems(String domainName){
        selectOptionByName(By.name("host"), domainName);
        click(By.className("SubmitButton"));

        if(canFindAnElement(By.className("domain_name")).toString().equals(domainName)){
            Log("The domain " + domainName + " has been selected.");
        }
        if(canFindAnElement(By.className("itemBlock"))){
            Log("Domain " + domainName + " - " + getCountOfElements(By.className("itemBlock")) + " elements.");
        }
        click(By.className("Logout"));
    }

    @Test(dependsOnMethods = "calcTheItems", dataProvider = "items", dataProviderClass = TestDataProvider.class)
    public void createNewItem(String domainName, String itemName, String subItemName){
        selectOptionByName(By.name("host"), domainName);
        click(By.className("SubmitButton"));

        if(canFindAnElement(By.className("domain_name")).toString().equals(domainName)){
            Log("The domain " + domainName + " has been selected.");
        }

        click(By.name("addItemButton"));
        setText(itemName, By.name("ContantTitle"));
        selectOptionByName(By.name("type"), "category");
        click(By.className("SubmitButton"));
    }
}