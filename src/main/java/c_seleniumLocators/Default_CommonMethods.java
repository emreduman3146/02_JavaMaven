package c_seleniumLocators;

import org.openqa.selenium.By;

//import static c_seleniumLocators.d_LocateWebElementByLinkText.driver;

public abstract class Default_CommonMethods
{
    protected void actionToPerform(String action, By locator, String... text) throws InterruptedException {

        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
        //  WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(10))
        //        .until(ExpectedConditions.elementToBeClickable(locator));

        Thread.sleep(5000);
        switch (action)
        {
            //case "sendKeys": driver.findElement(locator).sendKeys(text[0]);break;
            //case "click": driver.findElement(locator).click();   break;
            default:
                System.out.println("action name entered is undefined!!!");
        }
        Thread.sleep(3000);
    }

    //Notes:
    //Ileriki HTML webTable konusunda By.tagname() isimize yarayacak


}
