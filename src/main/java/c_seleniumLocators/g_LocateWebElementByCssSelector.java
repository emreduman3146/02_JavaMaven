package c_seleniumLocators;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//import static c_seleniumLocators.d_LocateWebElementByLinkText.driver;
import static c_seleniumLocators.d_LocateWebElementByLinkText.driver;
import static c_seleniumLocators.d_LocateWebElementByLinkText.goToURL;

public class g_LocateWebElementByCssSelector extends f_LocateWebElementByTagName//inheritance
{                                            //f_LocateWebElementByTagName implements CommonMethods


    //g classindan obje olustururken f(parent class);i kullandik, polimorphism yaptik
    static f_LocateWebElementByTagName polimorphismObjesi = new g_LocateWebElementByCssSelector();

    //kendi classimdan bir obje olusturdum
    static g_LocateWebElementByCssSelector normalObje = new g_LocateWebElementByCssSelector();

    public static void main(String[] args) throws InterruptedException {

        normalObje.signIn_Instagram_directly("https://www.instagram.com/accounts/login/", "automation@gmail.com", "selenium123");

    }

    /*
    //non-static method ya da degisken non-static method icinden direk(objesiz cagrilabilir)
    void nonStaticMethodum() throws InterruptedException {
        signIn_Instagram_directly("https://www.instagram.com/accounts/login/","automation@gmail.com","selenium123");
    }
    */


    //signIn = login
    void signIn_Instagram_directly(String url, String email, String password) throws InterruptedException {

        polimorphismObjesi.login(url, email, password);//hemen alttaki override olan login methodu calisir


        //7->By.cssSelector("tag#id[attribute=value][attribute=value]")
        //8->By.cssSelector("tag.className[attribute=value][attribute=value]")
        Thread.sleep(3000);
        WebElement warningText = driver.findElement(By.cssSelector("p#slfErrorAlert"));


        //true ya da false, available=mevcut olmak, musait olmak
        //isDisplayed= goruntuleniyor mu, gorebiliyor muyuz
        boolean isAvailable = warningText.isDisplayed();

        if (isAvailable)
            normalObje.signIn_Instagram_viaFacebook("facebookautomation@gmail.com", "facebookselenium123");

        else
            System.out.println("Successfully signed in!");


    }


    //java'da normal overriding budur
    //ama sirkette kimse bu methoda ihtiyac duymuyor
    //gereksiz yere bir method sabit yer kapliyor
    /*
    @Override
    public void login(String url, String email, String pswd) throws InterruptedException {

       // goToURL(url);

        //1->By.cssSelector("tag[attribute='value']")
        actionToPerform("sendKeys", By.cssSelector("input[name='username']"),email);//ilk input tag'ini locate eder
        actionToPerform("sendKeys",By.cssSelector("input[class='_aa4b _add6 _ac4d']"),pswd);
        actionToPerform("click",By.cssSelector("button[type='submit']"),"");//ilk button tag'ini locate eder

    }

     */


    void signIn_Instagram_viaFacebook(String email, String passwd) throws InterruptedException {

        //2->By.cssSelector("tag.className")
        WebElement loginWithFacebook = driver.findElement(By.cssSelector("span._ab37"));
        //3->By.cssSelector(".className")
        //3->By.cssSelector("#idName")

        loginWithFacebook = driver.findElement(By.cssSelector("._ab37"));

        loginWithFacebook.click();

        //javada normal polimorphsim bu
        //isimize yarar, algoritmamiz duzgunce calisir
        //login("","email","12345");

        //facebook bilgileri girilip, login tiklanacak

        //java konusu elimde varolan methodu override etmek
        //override ettigim method sadece 1 kereye mahsus kullanilsin istiyorum
        //kullanilsin ve bir daha kimse kullanamasin bu override edilen methodu
        //javada Anonymous class konusu satir 108-113 arasi anonymous(bilinmeyen) class
        new CommonMethods() {
            //Interface'in icinde imzasi yazan ama BODY;si olmayan
            @Override//method olusturuldu
            public void login(String url, String email, String pswd) throws InterruptedException {
                //goToURL();// gereksiz oldugu icin kullanmaya ihtiyac yok
                actionToPerform("sendKeys", By.cssSelector("input#email"), email);//4->By.cssSelector("tag#id")
                actionToPerform("sendKeys", By.cssSelector("#pass"), pswd);//5->By.cssSelector("#id")
                actionToPerform("click", By.cssSelector("button#loginbutton"), "");//???

            }
            //method kullanildi/cagrildi
        }.login("", email, passwd);//satir 114'teki logindir.tek seferlik kullanilan login method cagriliyor.


/*
        CSS SELECTOR - SUB-STRING
        ‘^' Sign - Signify's the prefix of the text    - input[attribute^='prefixValue']
        '$' sign - Signify's the suffix of the text    - input[attribute$='suffixValue']
        '*' sign - Signify's the substring of the text - input[attribute*='subStringValue']
*/


        //div[role='alert']-->bir diger css selector kalibi
        WebElement warningText = driver.findElement(By.cssSelector("div[role^=ale]"));
        warningText = driver.findElement(By.cssSelector("div[role$=lert]"));
        warningText = driver.findElement(By.cssSelector("div[role*=ler]"));
        boolean isAvailable = warningText.isEnabled();

        if (isAvailable)
             createFacebookAccount();
        else
           System.out.println("Successfully signed in via facebook!");


    }


    void createFacebookAccount() {

        //By.cssSelector("cssSelector>tag>cssselector>cssselector>tag")-> buyuk dede>dede>baba>ben
        WebElement createNewAccount=driver.findElement(By.cssSelector("div#blueBarDOMInspector > div > div:nth-child(2)>div>div>span>a"));


        //By.cssSelector("cssSelector tag cssselector cssselector tag")-> hiyerarşik olarak alt nesildeki elementi bulur
        createNewAccount=driver.findElement(By.cssSelector("div#blueBarDOMInspector >div>div:nth-child(2) a"));
        //div#blueBarDOMInspector  a:nth-child(2) bu da calisiyor
        createNewAccount.click();

        //sibling
        //cssSelector+tag[attribute='value']
        WebElement lastname=driver.findElement(By.cssSelector("div#fullname_field>div>div+div input"));
         lastname=driver.findElement(By.cssSelector("div#fullname_field>div>div+div[class='mbm _1iy_ _a4y rfloat _ohf'] input"));


        //cssSelector cssSelector cssSelector ...  - #u_0_c_XR dynamic oldugu icin bu locator saglikli degil
        // lastname=driver.findElement(By.cssSelector("#reg_form_box #fullname_field #u_0_c_XR .placeholder"));
        lastname.sendKeys("lastname01");






    }
}






