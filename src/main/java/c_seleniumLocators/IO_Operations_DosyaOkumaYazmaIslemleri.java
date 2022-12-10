package c_seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static c_seleniumLocators.j_UsageOf_FindElements_Method.driver;


//Parent classtir, sahip oldugu her seyi(private haric) child class'ina inheritance(miras) verir
//Peki Parent Class child class'ta olan fazladan ozellikleri nasil kullanabilir?
//import yoluyla(satir13)
public class IO_Operations_DosyaOkumaYazmaIslemleri
{

    static String filePath;
    static File benimTxtDosyam;//gloval classin mali olan variable
    static List<WebElement> webElementList;//null


    static void createTheTxtFile()
    {
        System.out.println("=============TXT DOSYA OLUSTURULUYOR===============");

        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        //C:\Users\Emre Duman\IdeaProjects\FullStack_WebAutomation_TestingBootcamp\02_JavaMaven

        //BEN TXT FILE'IMI NEREYE OLUSTURMAK ISTIYORSAM PATHINI ELINLE YAZ
        filePath=currentDir+"\\src\\main\\java\\c_seleniumLocators\\materials\\allLinksInPage.txt";


        try //Kodlarimi dene
        {
            benimTxtDosyam = new File(filePath);

            if (benimTxtDosyam.createNewFile())//dosya varsa false return eder
            {
                System.out.println("File created: " + benimTxtDosyam.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) //hata alirsam yakala
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void getAllLinkFromWebPage_putAllLinksInList(By by)
    {
        System.out.println("=============WEBPAGE'den TUM LINKLER ALINIYOR===============");

        webElementList = driver.findElements(by);//LIST Initialized

        System.out.println("webElementList.size() = " + webElementList.size());

        //java for each loop, listin icindeki tum elemanlari sirayla doner.
        for (WebElement element : webElementList) {
            System.out.println("element.getAttribute(\"href\") = " + element.getAttribute("href"));
        }

    }

    static void writeTheTxtFile()
    {
        System.out.println("=============DOSYA YAZILIYOR===============");

        try// .txt file'in icine yazmaya calis
        {
            //kalemle bana path'ini verdigin dosyayi yazarim
            FileWriter myWriter = new FileWriter(filePath);

            for (WebElement element:webElementList)
            {
                String anlikLink= element.getAttribute("href");

                //null bir ifade yok demektir, yok olan sey nasil yazilsinki
                if(anlikLink!=null)
                    myWriter.write(anlikLink+"\n");//linki yaz + alt satira gec
            }

            //icinde kalemle islem yaptigim txt file i kapat
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e)//hata alirsam goster
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void readTheTxtFile()
    {
        System.out.println("=============DOSYA OKUNUYOR===============");
        try
        {
           // Scanner myReader0 = new Scanner(System.in);//console'dan veri isterdi

            Scanner myReader = new Scanner(benimTxtDosyam);//sana verdigim file'i tara

            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();//txt file' i kapat
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void deleteTheTxtFile() {
        System.out.println("=============DOSYA SILINIYOR===============");

        if (benimTxtDosyam.delete())
        {
            System.out.println("Deleted the file: " + benimTxtDosyam.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

}
