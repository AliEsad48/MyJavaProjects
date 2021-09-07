package PersonalSystem;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Personals {


    private static int id = 1000;
    private String personalId;
    private String firstName;
    private String lastName;
    private int level;

    private String levelString;

    private static int maas;


    public void setPersonalId() {

        id++;
        this.personalId = level + "" + id;

    }

    public Personals() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Lütfen çalýþanýn adýný giriniz");

        this.firstName = scan.nextLine();

        System.out.println("Lütfen çalýþanýn soyadýný giriniz");

        this.lastName = scan.nextLine();

        System.out.println("Lütfen çalýþanýn seviyesini giriniz\n1- Junior\n2- Middle\n3- Senior");

        this.level = scan.nextInt();

        System.out.println("Lütfen çalýþanýn maaþýný giriniz");

        this.maas = scan.nextInt();

        if (level == 1) {

            this.levelString = "Junior";

        } else if (level == 2) {

            this.levelString = "Middle";

        } else if (level == 1) {

            this.levelString = "Senior";

        }

        setPersonalId();

        System.out.println("Id niz : " + personalId);

        System.out.println("Id nizi bir yere kaydetmenzi öneririz");

    }


    public String toString() {

        return "ÇALIÞANIN NUMARASI: " + personalId + "\nÇALIÞANIN ADI: " + firstName + " " + lastName + "\nÇALIÞANIN SEVÝYESÝ: " + levelString + "\nMAAS: " + maas + "$";


    }

    static Map<String, String> personalInfo = new HashMap<>();

    static Map<Integer, String> personalInfoInt = new HashMap<>();

    public static void mapePersonelEkleme() {

        Scanner scan = new Scanner(System.in);

        String stop = "";

        while (!stop.equalsIgnoreCase("dur")) {

            Personals p = new Personals();


            personalInfo.put(p.personalId, p.toString());

            System.out.println("Ýslemleri bitirmek için dur yazýnýz");
            System.out.println("Devam etmek için enter a basýnýz");

            stop = scan.nextLine();
        }

        islemSec();

    }

    public static void getPersonalInfo() {

        Scanner scan = new Scanner(System.in);

        String personelinIdsi = "";

        String sonuc = "";

        do {
            System.out.println("Lütfen çalýþanýn bilgilerini almak için idsini giriniz");
            System.out.println("Programý bitirmek için çýkýþ yazýnýz");

            personelinIdsi = scan.nextLine();

            sonuc = personalInfo.get(personelinIdsi);

            if (!personelinIdsi.equalsIgnoreCase("çýkýþ")) {

                System.out.println(sonuc);

            }

        } while (!personelinIdsi.equalsIgnoreCase("çýkýþ"));

        islemSec();

    }

    public static void personalSil() {

        Scanner scan = new Scanner(System.in);

        String personalinIdsi = "";

        String sonuc = "";

        do {
            System.out.println("Lütfen personali silmek için idsini giriniz");
            System.out.println("Programý bitirmek için çýkýþ yazýnýz");

            personalinIdsi = scan.nextLine();

            sonuc = personalInfo.remove(personalinIdsi);

            if (!personalinIdsi.equalsIgnoreCase("çýkýþ")) {

                System.out.println(sonuc);

                System.out.println("Personel listeden silindi");

            }

        } while (!personalinIdsi.equalsIgnoreCase("çýkýþ"));

        islemSec();

    }

    public static void islemSec() {

        System.out.println("Ýþlem seçin:\n1-Çalýþan Ekleme\n2-Çalýþanýn bilgilerini getirme\n3-Çalýþanýn bilgilerini silme\n4- Tüm çalýþanlarý görme");

        Scanner scan = new Scanner(System.in);

        int islem = scan.nextInt();

        switch (islem) {

            case 1:

                mapePersonelEkleme();
                break;

            case 2:

                getPersonalInfo();

                break;

            case 3:

                personalSil();

                break;

            case 4:

                tumPersonelleriGoster();

            default:
                System.out.println("Yanlýþ iþlem girdiniz 1,2 , 3 ya da 4 giriniz");
                islemSec();
                break;

        }

        islemSec();

    }

    public static void tumPersonelleriGoster() {


        for (int i = 1; i <= personalInfoInt.size(); i++) {

            System.out.println(personalInfoInt.get(i));

            System.out.println("--------------------------------");

        }
    }
}




