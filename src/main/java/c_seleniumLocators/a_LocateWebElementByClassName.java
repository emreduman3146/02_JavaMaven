package c_seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class a_LocateWebElementByClassName
{


    public static WebDriver driver;

    public static void main(String[] args)
    {

        launchChromeBrowser();

        sendKeysToSearchEngine();

    }


    private static void launchChromeBrowser() {
        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("--start-maximized");

        driver=WebDriverManager.chromedriver().avoidShutdownHook().capabilities(chromeOption).create();
        driver.get("https://google.com");
    }







    private static void sendKeysToSearchEngine() {

        //javayi kullanma yolu1
        //driver page gitti, element bul diye emir verdim, ne ile bulayim bu elementi
        //driver.findElement(By.className())

        driver.findElement(By.className("gLFyf")).sendKeys("facebook");//initializing


        //javayi kullanma yolu2
        WebElement googleAramaMotoru= driver.findElement(By.className("gLFyf"));
        googleAramaMotoru.sendKeys("facebook");


        //javayi kullanma yolu3
        By locator=By.className("gLFyf");
        WebElement googleAramaMotoruu= driver.findElement(locator);
        googleAramaMotoru.sendKeys("facebook");

        /*
        <input class="gLFyf" jsaction="paste:puy29d;" maxlength="2048" name="q" type="text"
        aria-autocomplete="both" aria-haspopup="false" autocapitalize="off" autocomplete="off"
        autocorrect="off" autofocus="" role="combobox" spellcheck="false" title="Search" value=""
        aria-label="Search" data-ved="0ahUKEwj7ztqQ1bb7AhV8LFkFHZyxCwYQ39UDCAY">
         */

        googleAramaMotoru.sendKeys(Keys.ENTER);//Klavyeden Enter tusuna bastik


    }

}
