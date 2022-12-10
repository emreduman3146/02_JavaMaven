package c_seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class i_RelativeLocators
{

    //Bu konunun resmi sitedeki anlatimi->
    //https://www.selenium.dev/documentation/webdriver/elements/locators/

    static WebDriver driver;//null

    public static void main(String[] args) {

        goToURL("https://demoqa.com/automation-practice-form");


        //1. relative locator  != xpath relative path
        //above();
        //above2();

        //below();
        //below2();
        //below3();

        //toLeftOf();
        //toRightOf();

         near();

    }






    private static void goToURL(String url) {
        driver= WebDriverManager.chromedriver().capabilities(new ChromeOptions().addArguments("--start-maximized")).avoidShutdownHook().create();
        driver.get(url);

    }

    private static void above()
    {
        //Basit id araciligiyla locate etme islemi
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("above@gmail.com");


        WebElement lastname = driver.findElement(with(By.tagName("input")).above(email));
         lastname.sendKeys("above");
    }

    private static void above2()
    {

        WebElement date = driver.findElement(By.id("dateOfBirth"));
        //date.sendKeys("09 Dec 2022");
        //date kullaniminda farkli methodlar var selenium'un sundugu

        //with methodu bizden filtreleme yapabilmek icin arguman ister
        WebElement mobile = driver.findElement(with(By.tagName("input")).above(date));
        mobile.sendKeys("123456789");
    }

    private static void below()
    {
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("below");

        //RelativeLocator.RelativeBy rLocator=RelativeLocator.with(By.tagName("input"));
        RelativeLocator.RelativeBy rLocator2=RelativeLocator.with(By.xpath("//input[@type='text']"));

        WebElement email = driver.findElement(with(rLocator2).below(firstName));
        email.sendKeys("below@gmail.com");

        //2 farkli locator da basarisiz oldu, baska webelementi locate ettiler

/*

        //yine farkli bir elementi locate etti
        WebElement labelEmail=driver.findElement(By.id("userEmail-label"));
        System.out.println("labelEmail.getText() = " + labelEmail.getText());
        WebElement emailInput=driver.findElement(with(By.xpath("//input[@type='text']")).toRightOf(labelEmail));
        emailInput.sendKeys("toRightOf kullanildi");



 */
    }


    private static void below2()
    {
        WebElement date = driver.findElement(By.id("dateOfBirth"));

        //below kullanimi basarisiz
        //WebElement subjects = driver.findElement(with(By.tagName("input")).below(date));

        //below kullanimi basarili
        //above kullansaydim Mobile kismina math yazardi
        WebElement subjects = driver.findElement(with(By.xpath("//input[@type='text']")).below(date));
        subjects.sendKeys("math");

        //calismadi-baska bir webelementi aldi
        //RelativeLocator.RelativeBy rLocator1=with(By.tagName("div"));

        //calisti-istedigimiz elemti aldi
        RelativeLocator.RelativeBy rLocator2=with(By.id("react-select-2-option-0"));

        WebElement cikti=driver.findElement(rLocator2.below(subjects));
        System.out.println("cikti.getAttribute(\"id\") = " + cikti.getAttribute("id"));

        //cikti.click();

    }

    private static void below3(){

        WebElement labelName=driver.findElement(By.id("userName-label"));
        System.out.println("labelName.getText() = " + labelName.getText());


        WebElement labelEmail=driver.findElement(with(By.tagName("label")).below(labelName));
        System.out.println("labelEmail.getText() = " + labelEmail.getText());

        //nested relative locator kullanma, icice kullanma
        WebElement mobileLabel=driver.findElement(with(By.tagName("label")).below(with(By.tagName("label")).below(labelName)));
        System.out.println("mobileLabel = " + mobileLabel.getAttribute("id"));

    }


    private static void toLeftOf()
    {
        //js objesi = guclendirilmis driver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement femaleCheckBox = driver.findElement(By.id("gender-radio-2"));

        //selenium click calismadigi zaman js click yoluna basvururz.
        //femaleCheckBox.click();

        //yesil yazi javascript dilidir.
        js.executeScript("arguments[0].click();", femaleCheckBox);

        WebElement male = driver.findElement(with(By.tagName("input")).toLeftOf(femaleCheckBox));
        js.executeScript("arguments[0].click();", male);

    }

    private static void toRightOf() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement femaleCheckBox = driver.findElement(By.id("gender-radio-2"));
        js.executeScript("arguments[0].click();", femaleCheckBox);


        WebElement other = driver.findElement(with(By.tagName("input")).toRightOf(femaleCheckBox));
        js.executeScript("arguments[0].click();", other);

    }

    private static void near() {
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement readingCheckBox = driver.findElement(By.id("hobbies-checkbox-2"));
       // readingCheckBox.click(); calismadi
        js.executeScript("arguments[0].click();", readingCheckBox);


        //calisti
        //WebElement sportsCheckBox = driver.findElement(with(By.tagName("input")).toLeftOf(readingCheckBox));

       //calismadi
        //WebElement sportsCheckBox2 = driver.findElement(with(By.tagName("input")).near(readingCheckBox));


        WebElement sportsCheckBox3 = driver.findElement(with(By.xpath("//*[text()='Music']")).near(readingCheckBox));

        //dersi tekrar ederken music labl'ini reference alarak onun near/yakinindaki checkbox'a tiklayin


        //sportsCheckBox.click();
        js.executeScript("arguments[0].click();", sportsCheckBox3);



    }


}
