package tipeandocodigo.com.overview.base;

import Utilities.GeneralUtils;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomDriver {
    WebDriver driver;
    private JavascriptExecutor js;

    public CustomDriver(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    /***
     * //Method to refresh the browser"
     * @param
     * @return void
     */
    public void refresh(){
        driver.navigate().refresh();
        System.out.println("The current browser was refreshed");
    }

    /***
     * Method to get the current webpage title
     *
     * @return String
     */
    public String getTitle(){
        String title = driver.getTitle();
        System.out.println("The current title is:"+title);
        return title;
    }

    /***
     * //method that base on the String locator should be something like "id=passwordField"
     * //a By.id("passwordfield") that can use in the getElement Method
     * @param locator
     * @return By
     */
    private By getByType(String locator){
        String type = locator.split("=>")[0];
        String realLocator = locator.split("=>")[1];
        By by = null;
        switch (type){
            case "xpath":{
                by = By.xpath(realLocator);
                break;
            }
            case "className":{
                by = By.className(realLocator);
                break;
            }
            case "classSelector":{
                by = By.cssSelector(realLocator);
                break;
            }
            case "id":{
                by = By.id(realLocator);
                break;
            }
            case "linkText":{
                by = By.linkText(realLocator);
                break;
            }
            case "name":{
                by = By.name(realLocator);
                break;
            }
            case "tagName":{
                by = By.tagName(realLocator);
                break;
            }
            case "partialLinkText":{
                by = By.partialLinkText(realLocator);
                break;
            }
        }
        return by;
    }

    /***
     * //method that base on the String locator should be something like "id=passwordField"
     * //with the help of the getType Method get the correct By type and the locator to return
     * //The correct WebElement
     * @param locator
     * @return WebElement
     */
    public WebElement getElement(String locator){
        WebElement element = null;
        By bytype = getByType(locator);
        try{
            element = driver.findElement(bytype);
            System.out.println("Element found");
        }catch (ElementNotFoundException e){
            System.out.println("Element was not fount with the locator: "+locator);
            e.printStackTrace();
        }
        return element;
    }
    public List<WebElement> getElements(String locator){
        List<WebElement> element = null;
        By bytype = getByType(locator);
        try{
            element = driver.findElements(bytype);
            System.out.println("Element found");
        }catch (ElementNotFoundException e){
            GeneralUtils.logMessage("Element was not fount with the locator: "+locator,"error");
            e.printStackTrace();
        }
        return element;
    }

}
