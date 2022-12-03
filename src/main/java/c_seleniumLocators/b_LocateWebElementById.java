package c_seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class b_LocateWebElementById
{
    public static WebDriver driver;//null

    public static void main(String[] args) throws InterruptedException {

        //launching the browser- browser'i baslatma
        launchChrome("https://www.facebook.com");

        //methodlar gorev parcaciklaridir. her methodun 1 gorevi olmalidir.
        sendEmail("email","automation@gmail.com");
        sendPassword("pass","Test123");




        //yukaridaki kodlarin overload edilmis halleri
        //overload demek method'un signature'inin degistirilmesi demek
        //methodun adi ayni, aldigi parametre cesidi farkli  oldugu icin methodun imzasi farkli demektir
        //Bu isleme javada OVERLOADING denir
        sendEmail(By.id("email"),"automation2@gmail.com");
        sendPassword(By.id("pass"),"Test1234");


    }


    private static void launchChrome(String url) {
       //  driver= WebDriverManager.chromedriver().avoidShutdownHook().create();
         driver=new ChromeDriver();
         driver.get(url);
    }

    private static void sendEmail(String id, String emailAddress) throws InterruptedException {

        //html ogrenirken id attribute(ozellik)'nun unique(essiz) oldugunu ogrendik
        //css file'in icine gidip

      /*  #idName
        {
        ........
        }

       */

        //1.yol
        WebElement email = driver.findElement(By.id(id));



        email.sendKeys(emailAddress);
        Thread.sleep(3000);//java compiler'a 23 saniye bekle diyorum ki websitesi belki yavas calisir
        //ya da html'in icinde itedigim webelementini bulmasi biraz zaman alabilie
        email.clear();//textBox'taki degeri temizler

        /*
        <input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal_email"
        placeholder="Email or phone number" autofocus="1" aria-label="Email or phone number">
         */
    }

    private static void sendPassword(String id, String passwd) throws InterruptedException {

        WebElement password= driver.findElement(By.id(id));
        password.sendKeys(passwd);
        Thread.sleep(3000);
        password.clear();//textBox'taki degeri temizler

        /*
        <input type="password" class="inputtext _55r1 _6luy _9npi" name="pass"
        id="pass" data-testid="royal_pass" placeholder="Password" aria-label="Password">
         */

    }




    public static void sendEmail(By by, String emailAddress)
    {
        WebElement email= driver.findElement(by);

        email.sendKeys(emailAddress);

        /*
        <input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal_email"
        placeholder="Email or phone number" autofocus="1" aria-label="Email or phone number">
         */
    }


    public static void sendPassword(By by, String passwd)
    {
        WebElement password = driver.findElement(by);
        password.sendKeys(passwd);

        /*
        <input type="password" class="inputtext _55r1 _6luy _9npi" name="pass"
        id="pass" data-testid="royal_pass" placeholder="Password" aria-label="Password">
         */
    }


}
