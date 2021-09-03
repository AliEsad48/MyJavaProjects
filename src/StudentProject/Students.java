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

        System.out.println("L�tfen ��rencinin ad�n� giriniz");

        this.firstName = scan.nextLine();

        System.out.println("L�tfen ��rencinin soyad�n� giriniz");

        this.lastName = scan.nextLine();

        System.out.println("L�tfen ��rencinin s�n�f�n� giriniz\n1- 1.S�n�f\n2- 2.S�n�f\n3- 3.S�n�f\n4-4.S�n�f");

        this.sinif = scan.nextInt();

        setStudentId();


    }

    public void kayit() {

        do {

            Scanner scan = new Scanner(System.in);

            System.out.println("L�tfen kay�t olmak istedi�iniz dersi se�iniz (��kmak i�in ��k�� yaz�n�z)");

            String ders = scan.nextLine();

            if (!ders.equalsIgnoreCase("��k��")) {

                if (!dersler.contains(ders)) {
                    dersler = dersler + "\n" + ders;

                    toplamFiyat = toplamFiyat + kursFiyati;
                } else {

                    System.out.println("Se�ti�iniz bir dersi bir daha se�emezsiniz");

                    kayit();

                }


            } else {

                break;

            }


        } while (true);

        System.out.println("A�a��daki derslere kay�t oldunuz : " + dersler);


    }

    public void odeme() {

        System.out.println("�demeniz gereken tutar : " + toplamFiyat + "?");

        Scanner scan = new Scanner(System.in);

        System.out.println("Tutar�n ne kadar�n� �imdi �demek istersiniz?");

        int odenenTutar = scan.nextInt();

        toplamFiyat = toplamFiyat - odenenTutar;

        System.out.println(odenenTutar + "$ �dedi�iniz i�in te�ekk�rler");

        System.out.println(odenenTutar + "$ �dediniz kalan tutar : " + toplamFiyat + "?");


    }

    public String toString() {

        return "��RENC�N�N NUMARASI: " + studentId + "\n��RENC�N�N ADI: " + firstName + " " + lastName + "\n��RENC�N�N SINIFI: " + sinif + "\n��RENC�N�N DERSLER�: " + dersler + "\nKALAN �DEME: " + toplamFiyat + "$";


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

            System.out.println("�slemleri bitirmek i�in dur yaz�n�z");
            System.out.println("Devam etmek i�in enter a bas�n�z");

            stop=scan.nextLine();
        }

        islemSec();

    }

    public static void getStudentsInfo(){

        Scanner scan=new Scanner(System.in);

        String ogrencininIdsi="";

        String sonuc="";

        do {
            System.out.println("L�tfen ��rencinin bilgilerini almak i�in idsini giriniz");
            System.out.println("Program� bitirmek i�in ��k�� yaz�n�z");

            ogrencininIdsi =scan.nextLine();

            sonuc = ogrenciBilgileri.get(ogrencininIdsi);

            if (!ogrencininIdsi.equalsIgnoreCase("��k��")) {

                System.out.println(sonuc);

            }

        }while (!ogrencininIdsi.equalsIgnoreCase("��k��"));

        islemSec();

    }

    public static void ogrenciSil(){

        Scanner scan=new Scanner(System.in);

        String ogrencininIdsi="";

        String sonuc="";

        do {
            System.out.println("L�tfen ��renciyi silmek i�in idsini giriniz");
            System.out.println("Program� bitirmek i�in ��k�� yaz�n�z");

            ogrencininIdsi =scan.nextLine();

            sonuc = ogrenciBilgileri.remove(ogrencininIdsi);

            if (!ogrencininIdsi.equalsIgnoreCase("��k��")) {

                System.out.println(sonuc);

                System.out.println("��renc listeden silindi");

            }

        }while (!ogrencininIdsi.equalsIgnoreCase("��k��"));

        islemSec();

    }

    public static void islemSec(){

        System.out.println("��lem se�in:\n1-��renci Ekleme\n2-��rencinin bilgilerini getirme\n3-��rencinin bilgilerini silme");

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
                System.out.println("Yanl�� i�lem girdiniz 1,2 ya da 3 giriniz");
                islemSec();
                break;

        }

        islemSec();

    }

}
