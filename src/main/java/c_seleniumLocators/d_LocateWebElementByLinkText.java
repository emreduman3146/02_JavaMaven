package c_seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class d_LocateWebElementByLinkText
{
    //access modifier'i olmayan variable/method default'tu
    //default erisim iznine sahip variable/method ancak ayni package'in icinden erisilebilirdi.
    static WebDriver driver= WebDriverManager.chromedriver().capabilities(new ChromeOptions().addArguments("--start-maximized")).avoidShutdownHook().create();


    public static void main(String[] args)
    {

        click_byLinkText();
    }

    //access modifier/erisim izni defaulttur
     static void goToURL(String url) {

        //local degiskenddir
         //local degiskenler sadece methodun icnde kullanilirlar
         //methoda ozgudurler.
        //driver.get(url);
        driver.navigate().to(url);

    }


    private static void click_byLinkText()
    {
            goToURL("https://www.selenium.dev/");
            /*
            <a href="https://seleniumconf.com/" target="_blank" class="btn btn-light btn-sm active"
            role="button" aria-pressed="true">Learn More</a>
             */
            WebElement readMore=driver.findElement(By.linkText("Learn More"));
            //otomatik olarak, text'i learn more olan ilk <a> tagini bulur
            //2 ve 3. <a> taglerini bulmaz
            //bu konuyu ilerde detayli islicez

            readMore.click();

    }






}
