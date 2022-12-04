package c_seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static c_seleniumLocators.d_LocateWebElementByLinkText.goToURL;
import static c_seleniumLocators.d_LocateWebElementByLinkText.driver;


//import static c_seleniumLocators.d_LocateWebElementByLinkText.driver;

public class f_LocateWebElementByTagName implements CommonMethods
{

    public static void main(String[] args) throws InterruptedException {

        f_LocateWebElementByTagName obje = new f_LocateWebElementByTagName();

        obje.login("https://www.instagram.com/accounts/login/","automation@gmail.com","selenium123");




    }

    //non-static bir method, static bir methodun icinden direk cagrilamaz
    //cagrilmasi icin, classtan bir tane objec olusturmak gerekir
    @Override
    public void login(String url, String email, String pswd) throws InterruptedException {

          //1.action
          goToURL(url);

          //2.action
          actionToPerform("sendKeys",By.tagName("input"),email);//ilk input tag'ini locate eder

          //3.action
          //eger bir locator bize birden fazla sonuc cikarirsa sadece ilkini kullanabilirdik
          //bu kotu yoldu, o yuzden seleniumda %90 cssSelector, xpath kullanilir
          //actionToPerform("sendKeys",By.tagName("input"),pswd);//ilk input tag'ini locate eder
          actionToPerform("sendKeys",By.name("password"),pswd);

          //4.action
          actionToPerform("click",By.className("_acap"),"");
          //birden fazla class'a sahip olan bu elemntin tum class isimlerini kullasak invalidSelector exception aliyoruz
          //cunku className() methodu sadece 1 class ister


      }






    /*daha sonrasinda abstract class'a tasidik*/
     void actionToPerform(String action, By locator, String... text) throws InterruptedException {

       //  String [] stringArray=["automation@gmail.com"];
       //  System.out.println(stringArray[0]);

         // Initialize and wait till element(link) became clickable - timeout in 10 seconds
      //  WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(10))
        //        .until(ExpectedConditions.elementToBeClickable(locator));

        Thread.sleep(4000);
        WebElement element =driver.findElement(locator);//webelementi bulundu


        switch (action)
        {
            case "sendKeys": element.sendKeys(text[0]);break;
            case "click":
                if(element.isEnabled())
                    element.click();
                else
                    System.out.println("The element is unable to click!!!");
                break;
            default:
                System.out.println("action name entered is undefined!!!");
        }//switch in sonu

    }//methodun sonu

    //Notes:
    //Ileriki HTML webTable konusunda By.tagname() isimize yarayacak

}
