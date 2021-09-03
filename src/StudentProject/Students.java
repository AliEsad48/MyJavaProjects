package StudentProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Students {

    private static int id = 1000;
    private String studentId;
    private String firstName;
    private String lastName;
    private int sinif;
    private String dersler = "";
    private static int kursFiyati = 1250;
    private static int toplamFiyat;

    public void setStudentId() {

        id++;
        this.studentId = sinif + "" + id;

    }

    public Students() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Lütfen öðrencinin adýný giriniz");

        this.firstName = scan.nextLine();

        System.out.println("Lütfen öðrencinin soyadýný giriniz");

        this.lastName = scan.nextLine();

        System.out.println("Lütfen öðrencinin sýnýfýný giriniz\n1- 1.Sýnýf\n2- 2.Sýnýf\n3- 3.Sýnýf\n4-4.Sýnýf");

        this.sinif = scan.nextInt();

        setStudentId();


    }

    public void kayit() {

        do {

            Scanner scan = new Scanner(System.in);

            System.out.println("Lütfen kayýt olmak istediðiniz dersi seçiniz (Çýkmak için Çýkýþ yazýnýz)");

            String ders = scan.nextLine();

            if (!ders.equalsIgnoreCase("çýkýþ")) {

                if (!dersler.contains(ders)) {
                    dersler = dersler + "\n" + ders;

                    toplamFiyat = toplamFiyat + kursFiyati;
                } else {

                    System.out.println("Seçtiðiniz bir dersi bir daha seçemezsiniz");

                    kayit();

                }


            } else {

                break;

            }


        } while (true);

        System.out.println("Aþaðýdaki derslere kayýt oldunuz : " + dersler);


    }

    public void odeme() {

        System.out.println("Ödemeniz gereken tutar : " + toplamFiyat + "?");

        Scanner scan = new Scanner(System.in);

        System.out.println("Tutarýn ne kadarýný þimdi ödemek istersiniz?");

        int odenenTutar = scan.nextInt();

        toplamFiyat = toplamFiyat - odenenTutar;

        System.out.println(odenenTutar + "$ ödediðiniz için teþekkürler");

        System.out.println(odenenTutar + "$ ödediniz kalan tutar : " + toplamFiyat + "?");


    }

    public String toString() {

        return "ÖÐRENCÝNÝN NUMARASI: " + studentId + "\nÖÐRENCÝNÝN ADI: " + firstName + " " + lastName + "\nÖÐRENCÝNÝN SINIFI: " + sinif + "\nÖÐRENCÝNÝN DERSLERÝ: " + dersler + "\nKALAN ÖDEME: " + toplamFiyat + "$";


    }

    static Map<String, String> ogrenciBilgileri = new HashMap<>();

    public static void mapeOgrenciEkleme() {

        Scanner scan = new Scanner(System.in);

        String stop = "";

        while (!stop.equalsIgnoreCase("dur")){

            Students s=new Students();

            s.kayit();

            s.odeme();

            ogrenciBilgileri.put(s.studentId , s.toString());

            System.out.println("Ýslemleri bitirmek için dur yazýnýz");
            System.out.println("Devam etmek için enter a basýnýz");

            stop=scan.nextLine();
        }

        islemSec();

    }

    public static void getStudentsInfo(){

        Scanner scan=new Scanner(System.in);

        String ogrencininIdsi="";

        String sonuc="";

        do {
            System.out.println("Lütfen öðrencinin bilgilerini almak için idsini giriniz");
            System.out.println("Programý bitirmek için çýkýþ yazýnýz");

            ogrencininIdsi =scan.nextLine();

            sonuc = ogrenciBilgileri.get(ogrencininIdsi);

            if (!ogrencininIdsi.equalsIgnoreCase("çýkýþ")) {

                System.out.println(sonuc);

            }

        }while (!ogrencininIdsi.equalsIgnoreCase("çýkýþ"));

        islemSec();

    }

    public static void ogrenciSil(){

        Scanner scan=new Scanner(System.in);

        String ogrencininIdsi="";

        String sonuc="";

        do {
            System.out.println("Lütfen öðrenciyi silmek için idsini giriniz");
            System.out.println("Programý bitirmek için çýkýþ yazýnýz");

            ogrencininIdsi =scan.nextLine();

            sonuc = ogrenciBilgileri.remove(ogrencininIdsi);

            if (!ogrencininIdsi.equalsIgnoreCase("çýkýþ")) {

                System.out.println(sonuc);

                System.out.println("Öðrenc listeden silindi");

            }

        }while (!ogrencininIdsi.equalsIgnoreCase("çýkýþ"));

        islemSec();

    }

    public static void islemSec(){

        System.out.println("Ýþlem seçin:\n1-Öðrenci Ekleme\n2-Öðrencinin bilgilerini getirme\n3-Öðrencinin bilgilerini silme");

        Scanner scan=new Scanner(System.in);

        int islem=scan.nextInt();

        switch (islem){

            case 1:

                mapeOgrenciEkleme();
                break;

            case 2:

                getStudentsInfo();

                break;

            case 3:

                ogrenciSil();

                break;

            default:
                System.out.println("Yanlýþ iþlem girdiniz 1,2 ya da 3 giriniz");
                islemSec();
                break;

        }

        islemSec();

    }

}
