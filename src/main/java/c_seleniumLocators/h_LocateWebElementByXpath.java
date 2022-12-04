package c_seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;
import java.net.URL;

public class h_LocateWebElementByXpath
{

    static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        goToUrl();

        //2.sayfaya goturur
        //absolutePath_relativePath_kullanimi();

        //2.sayfaya goturur
        parentChildElementIliskisi();

        detayli_RelativeXPath_Kullanimi();


        //selenium'da click yapmanin cesitleri
        typesOfClicking();

        xPath_axes_methods();


    }


    private static void goToUrl() throws MalformedURLException {
       ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");

        driver=WebDriverManager.chromedriver().avoidShutdownHook().capabilities(options).create();
        URL url=new URL("https://demoqa.com/");//hard coding
        driver.navigate().to(url);
    }

    private static void absolutePath_relativePath_kullanimi() throws MalformedURLException
    {
        //declaration
        WebElement elementsCategory;//null

        //1->Absolute Path
        elementsCategory=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div/div[3]/h5"));

        //2->Relative Path - tagName[@attributeName='value']==//h5[text()='Elements']
        elementsCategory=driver.findElement(By.xpath("//div[@class=\"card-body\"]"));
        elementsCategory=driver.findElement(By.xpath("//div[@class='card-body']"));
        // bu xpathler de calisir ->
        //      (//div[@class='card-body'])[1]
        //      //h5
        //      //(h5)[1]

        //1 ve 2 nin beraber kullanimi
        elementsCategory=driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div/div[1]/div/div[3]/h5"));

        elementsCategory.click();

    }

    private static void parentChildElementIliskisi() {


        //By.xpath("//div[@id='app']/div/div/div[2]/div/div[1]/div/div[3]/h5")
        WebElement elementsCategory=driver.findElement(By.xpath("//div[@id='app']"));
        // WebElement ilkElementeBagli_IkinciWebelement=elementsCategory.findElement(By.xpath(".//div/div/div[2]/div/div[1]/div/div[3]/h5"));

        WebElement ilkElementeBagli_IkinciWebelement=elementsCategory.findElement(By.xpath(".//div[@class='card-body']/h5"));

        ilkElementeBagli_IkinciWebelement.click();
    }

    private static void detayli_RelativeXPath_Kullanimi()
    {
        //ayni tag ve attribute 'e sahip elementlerin 5.sini locate et
        By xpath = By.xpath("(//span[@class='text'])[5]");
        WebElement buttonsSecenegi;

        buttonsSecenegi = driver.findElement(By.xpath("(//*[@class='text'])[5]"));

        //tag[.='text'] - //*[.='text']
        buttonsSecenegi = driver.findElement(By.xpath("//span[.='Buttons']"));
        buttonsSecenegi = driver.findElement(By.xpath("(//*[.='Buttons'])[2]"));
        buttonsSecenegi.click();

        driver.findElement(By.xpath("//*[.='Buttons']"));

    }

    private static void typesOfClicking() {


        Actions actions = new Actions(driver);
        //actions' in icinde guclendirillmis driver vardir


        //cift tiklama
        //tagName[starts-with(@attribute,'Value')]
        WebElement ilkButton=driver.findElement(By.xpath("(//button[starts-with(@class,'btn bt')])[1]"));

        //*[contains(@type,'sub')]
        ilkButton=driver.findElement(By.xpath("(//button[contains(@class,'n bt')])[1]"));

        //tag[text()='value']
        ilkButton=driver.findElement(By.xpath("//button[text()='Double Click Me']"));

        //*[contains(text(),'here')]
        ilkButton=driver.findElement(By.xpath("//button[contains(text(),'Double Click')]"));

        //ilkButton.doubleClick(); - boyle bir method yoktur
        actions.doubleClick(ilkButton).perform();


        //sag tiklama
        //tag[contains(@type,'sub')]
        WebElement ikinciButton=driver.findElement(By.xpath("//button[contains(@id,'rig')]"));

        //*[@type='submit' or @name='btnReset']
         ikinciButton=driver.findElement(By.xpath("//button[text()='Right Click Me' or @id='rightClickBt']"));

        //input[@type='submit' and @name='btnLogin']
         ikinciButton=driver.findElement(By.xpath("//button[@type='button' and  @id='rightClickBtn']"));

         actions.contextClick(ikinciButton).perform();

    }


    private static void xPath_axes_methods()
    {
        //JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver.
        JavascriptExecutor js = (JavascriptExecutor) driver;





        //*[@tag='value']//child::tagName
        //*[@tag='value']//child::tagName[1]
        WebElement formOption_icon=driver.findElement(By.xpath("//*[text()='Forms']//child::span"));
        //  //*[text()='Forms']//span[@class='pr-1'] bu da calisir
        //  xpath + xpath kalibi





        try {
            formOption_icon.click();//element gozukmedigi icin selenium click yapamaz
        }catch (Exception e){
            System.out.println(e);
            /*
            Selenium'da ElementClickInterceptedException neden olur?
            Selenyum/Otomasyon araçları, uygulamanın yanıtından çok daha hızlı çalışır
            Bazen internetin ve sistem donanımının hızı, uygulamanın daha yavaş çalışmasına neden olur.
            Developer, hedef element için bir parent element eklemiş olabilir
            Web sitesinin kötü tasarımı

            Bu hatanin cozulmesi icin yapacaginiz yanlis uygulamalar
            1-Element'e israrla tiklamaya calismak
            2-Thread.sleep() kullanmak
            3-Selenium Explicitly wait kullanmak

            Dogru cozumu
            1
             */
            js.executeScript("arguments[0].click();", formOption_icon);

            /*
            "arguments[0].click();" bir javaScript kodudur ve ne anlama gelir?

             Object executeScript(String script, Object... args);
             methodunda parametre olarak verdigimiz argumanlara emir veriyoruz
             mesela->arguments[0].click()
             anlami->0. indexteki parametreyi(yani webElementini al ve click yap)

             */

            /*
            Neden selenium'un click() methodu hata firlatti da js'nin click()'i calisti???
            Cevabi burda->http://makeseleniumeasy.com/2019/06/15/selenium-interview-question-8-what-is-difference-between-webdriver-click-and-javascript-click-methods/

             */

        }



        //Kendisi dahil altindaki ellementleri icerir
        //div[contains(@id,'dateOfBirth-wrapper')]//self::input
        //div[contains(@id,'dateOfBirth-wrapper')]//self::*


        //altindaki elementleri gosterir
        //div[contains(@id,'dateOfBirth-wrapper')]//child::input
        //div[contains(@id,'dateOfBirth-wrapper')]//child::*

        //parent elementi gosterir
        //div[contains(@id,'dateOfBirth-wrapper')]//parent::form



    }




}

