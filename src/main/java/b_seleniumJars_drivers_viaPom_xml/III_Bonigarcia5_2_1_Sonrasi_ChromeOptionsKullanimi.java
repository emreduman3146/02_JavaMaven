package b_seleniumJars_drivers_viaPom_xml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class III_Bonigarcia5_2_1_Sonrasi_ChromeOptionsKullanimi
{


    public static void main(String[] args) throws InterruptedException {
       // Bonigarcia5_2_1_Sonrasi_chromeOptionsKullanimi1();


        Bonigarcia5_2_1_Sonrasi_chromeOptionsKullanimi2();
    }



    private static void Bonigarcia5_2_1_Sonrasi_chromeOptionsKullanimi1()
    {
        //Bonigarcia5_2_1_Oncesi Kullanimi asagidaki gibiydi, 27 November 2022 bu konuyu ogrenmistik
        /*
        ChromeOptions options0 = new ChromeOptions();
        options0.addArguments("--headless");
        WebDriver driver0=new ChromeDriver(options0);
         */


        //Bonigarcia5_2_1_Sonrasi
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito","--start-maximized");//--headless",


        WebDriver driver= WebDriverManager.chromedriver().avoidShutdownHook().capabilities(options).create();
        driver.get("https://www.google.com");
    }

    private static void Bonigarcia5_2_1_Sonrasi_chromeOptionsKullanimi2() throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});//controlled by chrome yazisi kaldirilir
        options.addArguments("--incognito","--start-maximized");//--headless",


        WebDriver driver= WebDriverManager.chromedriver().avoidShutdownHook().driverVersion("106.0.5249.61").capabilities(options).create();
        //driver.manage().window().maximize();//ChromeOptions sayesinde maximize ayarini yaptim, bu satira ihtiyac kalmadi
        driver.get("https://www.google.com");
        Thread.sleep(10000);



    }

}
