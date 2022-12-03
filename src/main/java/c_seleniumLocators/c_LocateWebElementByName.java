package c_seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static c_seleniumLocators.b_LocateWebElementById.*;
//import static c_seleniumLocators.b_LocateWebElementById.sendEmail;
//import static c_seleniumLocators.b_LocateWebElementById.sendPassword;




public class c_LocateWebElementByName
{
    //WebDriver Interface'ine ait bir degisken tipi declare ettik. Initialize etmedik daha
    //reference tipli degiskenlerin default degeri null'dir.
    //Default deger demek, eleimizdeki variable(degisken)'a bir value(deger) atamadik demektir.
    //static keyword'unu kullaniyoruz.
    //Cunku static bir variable olan "driver", static methodlarin icinden direk cagrilabilir.
    //static olmasaydi object(nesne) olusturarak cagirmak zorunda kalirdik.
    static WebDriver driver;//artik null degil


    public static void main(String[] args) {

        //driver calisiyor artik
        launchBrowser("chrome", "https://www.facebook.com");

        //ilk c'de driver;i baslatip facebook'a gitmistik
        //b class'indaki null olan driver'i da baslatmam gerekiyor.
        //nasil yapabilirim, elimdeki c arabasini copy yap b arabasina ata
        b_LocateWebElementById.driver=driver;//
        //b_LocateWebElementById Class'inin public methodlarina eristik ve kullandik


        sendEmail(By.name("email"), "automation2@gmail.com");
        sendPassword(By.name("pass"), "Test1234");


        //java dili cok guzel bir dildir.
        //Her seyin en kisa ve en dynamic yolu vardir.
        //Hadi 1 method yazalim ve yukardaki 2 methodun yaptigi isleri yapsin


        sendKeysToTextbox(By.name("email"),"automation@gmail.com");
        sendKeysToTextbox(By.name("pass"),"Test1234");

    }


    private static void launchBrowser(String browser, String url)
    {
        if(browser.equals("Firefox"))
        {
            WebDriverManager.firefoxdriver().create();
            driver = new FirefoxDriver();
        }
        else if (browser.equals("chrome"))
        {
            //WebDriverManager.chromedriver().create();
            driver = new ChromeDriver();
        }
        else
        {
            WebDriverManager.edgedriver().create();
            driver = new EdgeDriver();
        }
        //Kod tekrari yapmaktan kurtulduk
        driver.get(url);
        driver.manage().window().maximize();

    }

    private static void sendKeysToTextbox(By by,String text)
    {

        WebElement textBox=driver.findElement(by);
        textBox.sendKeys(text);
    }



}
