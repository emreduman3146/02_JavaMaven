package b_seleniumJars_drivers_viaPom_xml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class IV_WebDriver_Interface_neden_onemli
{


    public static void main(String[] args)
    {
      //  webDriverInterface_ilePolimorphismYapmasaydik_NeOlurdu();
       webDriverInterface_ilePolimorphism_kolayligi();

    }














    private static void webDriverInterface_ilePolimorphismYapmasaydik_NeOlurdu()
    {
        //polimorphism ozelligi kullanilmadigi zaman kotu kod yaziyoruz
        //binlerce satirlik programlarda proje coker

        String browser="chrome";//hard coding- sabit kod, elle yazilan kod
        ChromeDriver chromeDriver;//null
        FirefoxDriver firefoxDriver;//null
        EdgeDriver edgeDriver;//null -atama yapilmamis, deger tutmayan reference tipli veri


        if (browser.equals("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();//bonigarcia 5_2_1 oncesi kullanimi
            firefoxDriver=new FirefoxDriver();
            firefoxDriver.get("https://www.google.com");
            firefoxDriver.manage().window().maximize();
        }
        else if (browser.equals("chrome"))
        {
            ChromeDriver d= (ChromeDriver) WebDriverManager.chromedriver().create();//bonigarcia 5_2_1 sonrasi kullanimi
            d = new ChromeDriver();
            d.get("https://www.google.com");
            d.manage().window().maximize();
        }
        else
        {
            WebDriverManager.edgedriver().create();
            edgeDriver = new EdgeDriver();
            edgeDriver.get("https://www.google.com");
            edgeDriver.manage().window().maximize();
        }

    }


    private static void webDriverInterface_ilePolimorphism_kolayligi()
    {
        //sart ne olursa olsun
        String browser="chrome";//hard coding

        //ayni degisken initialize edilecek
        WebDriver driver;//interface, chromeDriver(),fireFoxDriver(),... annesi



        if(browser.equals("Firefox"))
        {
            driver=(FirefoxDriver) WebDriverManager.firefoxdriver().avoidShutdownHook().create();//bonigarcia 5.2.1 sonrasi gelen ozellik kullanimi
        }
        else if (browser.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else
        {
            //duplication- tekrarlama ayni seyi
            WebDriverManager.chromedriver().create();
            driver = new EdgeDriver();
        }
        //Kod tekrari yapmaktan kurtulduk
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

    }


}
