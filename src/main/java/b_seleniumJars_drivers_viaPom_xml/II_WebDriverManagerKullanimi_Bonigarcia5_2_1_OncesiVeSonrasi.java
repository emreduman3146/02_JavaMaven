package b_seleniumJars_drivers_viaPom_xml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class II_WebDriverManagerKullanimi_Bonigarcia5_2_1_OncesiVeSonrasi
{

    public static void main(String[] args) throws InterruptedException
    {



        launchChromeDriver_Bonigarcia5_2_1_Sonrasi();

        launchChromeDriver_Bonigarcia5_2_1_Oncesi();


        launchChromeDriver_Bonigarcia5_2_1_Sonrasi_avoidShutdownHook_Kullanimi();
        launchFireFoxDriver_Bonigarcia5_2_1_Sonrasi_avoidShutdownHook_Kullanimi();
        launchEDGEDriver_Bonigarcia5_2_1_Sonrasi_avoidShutdownHook_Kullanimi();

    }




    private static void launchChromeDriver_Bonigarcia5_2_1_Oncesi() {

        WebDriverManager.chromedriver().setup();//Note-> selenium 4.6.0 sonrasini kullaniyorsak bu satiri yazmasak oluyordu
        WebDriver driver=new ChromeDriver();//Cunku yukaridaki kodun aynisi bu satirda "new ChromeDriver()"in icinde calistiriliyor
        driver.get("https://google.com");

    }


    private static void launchChromeDriver_Bonigarcia5_2_1_Sonrasi() {

        //Bonigarcia5_2_1_Sonrasi
        //WebDriverManager.chromedriver().setup();//kullanimi eskidi.

        //Yeni kullanim sekli asagidaki gibidir.
        WebDriver driver= WebDriverManager.chromedriver().create();
        //Yukaridaki kod-> WebDriver driver=new ChromeDriver(); kullaniminda farksizdir, ayni isi yapar
        //Peki neden cesit cesit kod var? Hepsi tipatip ayni gorevleri mi yapiyor?
        //Bu sorunun cevabini bir sonraki methodumuzda ogrenecegiz!!!

        driver.get("https://www.google.com");

        //driver.quit()  yapmadan otomatik kapaniyor
    }


    private static void launchChromeDriver_Bonigarcia5_2_1_Sonrasi_avoidShutdownHook_Kullanimi()
    {


        //avoidShutdownHook() methodu ile driver.quit() otomatik olarak calismaz
        WebDriver driver= WebDriverManager.chromedriver().avoidShutdownHook().create();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // driver.quit();
    }

    private static void launchFireFoxDriver_Bonigarcia5_2_1_Sonrasi_avoidShutdownHook_Kullanimi()
    {
        WebDriver driver= WebDriverManager.firefoxdriver().avoidShutdownHook().create();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // driver.quit();
    }



    private static void launchEDGEDriver_Bonigarcia5_2_1_Sonrasi_avoidShutdownHook_Kullanimi() {
        WebDriver driver= WebDriverManager.edgedriver().avoidShutdownHook().create();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // driver.quit();
    }



}
