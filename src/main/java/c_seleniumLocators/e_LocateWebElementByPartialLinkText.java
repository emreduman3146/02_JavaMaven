package c_seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import static c_seleniumLocators.d_LocateWebElementByLinkText.driver;
import static c_seleniumLocators.d_LocateWebElementByLinkText.goToURL;

public class e_LocateWebElementByPartialLinkText
{

    public static void main(String[] args) {
        click_byPartialLinkText();
    }

    private static void click_byPartialLinkText()
    {
        goToURL("https://www.google.com/");

        WebElement googleAramaMotoru= driver.findElement(By.className("gLFyf"));
        googleAramaMotoru.sendKeys("facebook");
        googleAramaMotoru.sendKeys(Keys.ENTER);

        //aylar sonra linktext degisirse, bu kod noSuchElements hatasi verir.
        //linkText'in cok uzun oldugu zamanalarda kullanilir


        //Facebook - log in or sign up
       WebElement facebookLink=driver.findElement(By.partialLinkText("Facebook - "));
        facebookLink.click();

    }
}
