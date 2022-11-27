package a_createJar_install_in_m2_useInAnotherMVNProject;


import com.duman.RationalNumber;

public class UsingMyOwnDependecy
{
    public static void main(String[] args) {

    //maven dependecy jat file'imimz
    RationalNumber rasyonelSayi1=new RationalNumber(1,2);
    RationalNumber rasyonelSayi2=new RationalNumber(3,7);

    System.out.println("rasyonelSayi1.add(rasyonelSayi2) = " +
            rasyonelSayi1.add(rasyonelSayi2));

    System.out.println("rasyonelSayi1.compareTo(rasyonelSayi2) = " +
                rasyonelSayi1.compareTo(rasyonelSayi2));

    //ders1'de yaptigimiz ilkel java project'in jar file'i
    // masaustune kaydetmistik
    //ilkel/manuel yollarla ekledik


    main.RationalNumber rs=new main.RationalNumber(4,5);

    RationalNumber rs2 = new RationalNumber();
    rs2.version2_YayinlanmadanOnceYaptigimDegisiklik();

    rs2.birSayininKupunuAl(5);




        RationalNumber rationalNumber = new RationalNumber(4,5);
        RationalNumber rationalNumber2= new RationalNumber(7,3);
        System.out.println("rationalNumber.add(rationalNumber2) = " + rationalNumber.add(rationalNumber2));

        RationalNumber rationalNumber3=new RationalNumber();
        rationalNumber3.version2_YayinlanmadanOnceYaptigimDegisiklik();
    }
}
