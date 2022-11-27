package b_seleniumJars_drivers_viaPom_xml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class I_SettingSeleniumJarsAndDrivers_version4_6_0_OncesiVeSonrasi
{
    //Selenium Kodlarini kullanmay baslayalim/
    //1->.exe driver larina ihtiyacim var
    //2->selenium .jar filelarina ihtiyacim var
    public static WebDriver driver;//null

    //Dependency ler nereden alinir???  https://mvnrepository.com/ git ve WebDriverManager ara



    public static void main(String[] args) throws InterruptedException {

        //navigateToGoogleChrome_Selenium4_6_0Oncesi("https://www.google.com","googleBrowser");

        navigateToGoogleChrome_Selenium4_6_0_Sonrasi("https://www.google.com","Google");

        navigateToForefoxMozilla_Selenium4_6_0_Sonrasi("https://www.firefox.com","Download Firefox — Fast, Private & Free — from Mozilla (CA)");

        navigateToMicrosoftEdge_Selenium4_6_0_Sonrasi("https://www.youtube.com","YouTube");
    }




    public static void navigateToGoogleChrome_Selenium4_6_0_Oncesi(String url, String expectedTitle) throws InterruptedException {


        //NOTE
        //JAVA projesinde (mavensiz)
        // System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/OneDrive/Documents/seleniumDependencies/drivers/chromedriver.exe"); kullaniriz.


        //MAVEN projesinde ise chrome driver icin WebDriverManager kullaniriz
        //WebDriverManager Abstract Class'i "bonigarcia" dependency'sinden geliyor
        WebDriverManager.chromedriver().setup();//selenium 4.0.6 oncesi version kullaniyorsak, bu satiri yazmak zorundayiz

       // WebDriverManager.chromedriver().driverVersion("106.0.5249.61").setup();
        //kendi browser'imizin ust version'unu yazarsak launch etmez


        driver = new ChromeDriver();//initializing

        goToUrl_And_verifyTheTitle(url,expectedTitle);

    }

    private static void navigateToGoogleChrome_Selenium4_6_0_Sonrasi(String url, String expectedTitle) throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz,
        // yazarsak hata almayiz!!!!!
        //Ama yazmasak da calisiyor

        //WebDriverManager bonigarcia dependency'den geliyordu, artik ona ihtiyacimiz silebilriz
        //ihtiyacimiz olan driver(herhangibir browserin driveri) selenium 4.6 dependency'sinden geliyor

        driver = new ChromeDriver();  //https://mvnrepository.com/ git ve selenium java ara

        goToUrl_And_verifyTheTitle(url,expectedTitle);
    }

    private static void navigateToForefoxMozilla_Selenium4_6_0_Sonrasi(String url, String expectedTitle) throws InterruptedException {

        //WebDriverManager.firefoxdriver().setup();
        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz
        //WebDriverManager bonigarcia dependency'den geliyordu, artik ona ihtiyacimiz silebilriz
        //ihtiyacimiz olan driver(herhangibir browserin driveri) selenium 4.6 dependency'sinden geliyor

        driver = new FirefoxDriver();//I CREATED AN OBJECT FROM FirefoxDriver CLASS if ı dont use this object a blank webpage will be opened

        goToUrl_And_verifyTheTitle(url,expectedTitle);


    }

    private static void navigateToMicrosoftEdge_Selenium4_6_0_Sonrasi(String url, String expectedTitle) throws InterruptedException {

        //WebDriverManager.edgedriver().setup();
        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz
        //WebDriverManager bonigarcia dependency'den geliyordu, artik ona ihtiyacimiz silebilriz
        //ihtiyacimiz olan driver(herhangibir browserin driveri) selenium 4.6 dependency'sinden geliyor

        driver = new EdgeDriver();//I CREATED AN OBJECT FROM EdgeDriver CLASS if ı dont use this object a blank webpage will be opened

        goToUrl_And_verifyTheTitle(url,expectedTitle);


    }

    private static void goToUrl_And_verifyTheTitle(String url,String expectedTitle) throws InterruptedException {
        driver.get(url);//https://www.google.com

        driver.manage().window().maximize();//sinema modu (carpı falan dahi olmaz yukarda)
        Thread.sleep(3000);

        String actualTitle=driver.getTitle();//html tag : <title> Google </title>
        //inspect  +  ctrl+F  +  //title
        //hover over web tab to see title
        System.out.println(actualTitle);

        if(actualTitle.equals(expectedTitle))//String.equals(String)
            System.out.println("pass");
        else
            System.out.println("fail"+"\n"+
                    "Actual Title:"+actualTitle+"\n"+
                    "Expected Title:"+expectedTitle);



        //JAVA'DA TERNARY KONUSU- IF ELSE KULLANIMININ KISA HALI
        System.out.println(actualTitle.equals(expectedTitle) ? "Pass" : "fail"+"\n"+
                "Actual Title:"+actualTitle+"\n"+
                "Expected Title:"+expectedTitle);

        //driver.close();//ı closed the page

    }
}
