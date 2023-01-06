package c_seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class j_UsageOf_FindElements_Method extends IO_Operations_DosyaOkumaYazmaIslemleri
{
    static WebDriver driver;
    static JavascriptExecutor js ;

    public static void main(String[] args) throws InterruptedException {


        //Precondition(Ön Şart) of a scenario(senaryo)
        goToURL("https://demoqa.com/automation-practice-form");

        //Scenario1
        //findAllWebelements_byTheGivenLocator_clickTheWantedElement(By.tagName("label"));

        //Scenario2
         //findAllWebelements_byTheGivenLocator_selectAllCheckBoxs(By.xpath("//input[@type='checkbox' and @class=\"custom-control-input\" ]"));

        //Scenario3
       findAllLinks_inThePage_storeThem_inTxtFile(By.tagName("a"));//<a> html-> link anlamina geliyor



    }



    private static void goToURL(String url) {
        driver= WebDriverManager.chromedriver().capabilities(new ChromeOptions().addArguments("--start-maximized")).avoidShutdownHook().create();
        js= (JavascriptExecutor) driver;
        driver.get(url);

    }

    private static List findAllWebelements_byTheGivenLocator_clickTheWantedElement(By by) throws InterruptedException {


        //WebElement label1=driver.findElement(by);//sadece 1 labe;i locate ederdik, o da ilki olurdu


        webElementList = driver.findElements(by);//LIST Initialized
        //driver.findElements(by); icinde bir suru webelement iceren bir hazir list return eder

        System.out.println("webElementList.size() = " + webElementList.size());


        //java bilgisi:foreach loop'u'
        for (WebElement element:webElementList)
        {
            System.out.println("element.getText() = " + element.getText());
            if(element.getText().equals("Male"))
            {
                WebElement radioButtondriver=driver.findElement(with(By.tagName("input")).near(element));
               // radioButtondriver.click();//yuvarlak cisme tiklayamiyor
                js.executeScript("arguments[0].click();", radioButtondriver);
            }
        }

        return webElementList;
    }

    private static List findAllWebelements_byTheGivenLocator_selectAllCheckBoxs(By by)
    {

        //Algorithma==hikaye
        //webpage'de bir user en fazla 5 tane hobby e tiklayabilir
        //webpage'10 tane hobby cesidi var

        //3 tane webelement iceren bir list reurn eder
        //bu listi elimde tutabilmek icin de "webElementList"a atadim
        webElementList = driver.findElements(by);//LIST Initialized

        System.out.println("webElementList.size() = " + webElementList.size());


        int baslangic=0,limit=2;

        for (WebElement element : webElementList)
        {
            System.out.println("element.getText() = " + element.getText());
            if (element.getAttribute("type").equals("checkbox"))
            {
                js.executeScript("arguments[0].click();", element);
                baslangic++;//0-1-2
                if(baslangic==limit)
                    break; //break kirmak, loop'u kir,
            }
        }
        return webElementList;
    }

    private static void findAllLinks_inThePage_storeThem_inTxtFile(By by)
    {
        //txt file olustur , write,  read ...  JAVADA INPUT/OUTPUT OPERATIONS

        //Bir tane .txt file olustur. Ici bos
        createTheTxtFile();

        //tum linkleri al ve bir java list'in icine depola
        getAllLinkFromWebPage_putAllLinksInList(by);

        //list'in icindeki degerleri .txt file'a depola
        writeTheTxtFile();


        //bu son 2 method tamamen java'da dosya okuma yazma konusunun tekrari duzgun olsun diye yazildi
        //seleniumla alakasi yok


        //elimizdeki txt i file'a gider, icindeki satirlari tek tek okur
         readTheTxtFile();

         //elimizdeki txt file'in path'ine bakar ve siler
        // deleteTheTxtFile();


         

    }




}
