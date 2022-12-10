package c_seleniumLocators;


//programlamada catidir.
//elimdeki classlari bir cati altinda toplar
//interface'in icinde elimdeki classlar tarafinca kullanilan ortak methodlarin ismi olur
public interface CommonMethods
{
    //interface'in icine yazilan her method imzasi public'tir(by default)
    public void login(String url, String email, String pswd) throws InterruptedException;

    //BURDAKI METHODLARIN BODY'SI YOK
}
