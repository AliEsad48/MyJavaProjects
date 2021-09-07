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
    static String SIFRE="1453";
    static String gsifre="";

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

        System.out.println("Lütfen öðrencinin sýnýfýný giriniz\n1- 1.Sýnýf\n2- 2.Sýnýf\n3- 3.Sýnýf\n4- 4.Sýnýf");

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

        System.out.println("Id'niz : " + studentId);


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

    public static void mapeOgrenciEkleme() throws InterruptedException {

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

    public static void getStudentsInfo() throws InterruptedException {

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

    public static void ogrenciSil() throws InterruptedException {

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

    public static void islemSec() throws InterruptedException {

        Scanner scan=new Scanner(System.in);

        System.out.println("Lütfen gitmek istediðiniz ekraný giriniz:\n1-Admin Ekraný\n2-Kayýt Ekraný");

       int islem2=scan.nextInt();



        switch (islem2){

            default:
                System.out.println("Yanlýþ iþlem girdiniz 1,2 ya da 3 giriniz");
                islemSec();
                break;
            case 2:

                mapeOgrenciEkleme();

                break;
            case 1:


                int count=3;

                System.out.println("Lütfen admin þifresini giriniz : ");

                gsifre=scan.nextLine();

                gsifre=scan.next();

                System.out.println("Þifre kontrol ediliyor......");
                Thread.sleep(4000);

                do {



                    if (gsifre.equals(SIFRE)) {

                        adminIslemSec();


                    } else {

                count--;

                System.out.println("Kalan hakkýnýz : " + count);

                if (count!=0) {
                    System.out.println("Lütfen admin þifresini giriniz : ");


                    gsifre= scan.nextLine();
                    gsifre=scan.next();

                    System.out.println("Þifre kontrol ediliyor......");
                    Thread.sleep(4000);
                } else {

                    System.out.println("Hakkýnýz doldu seçim ekranýna gidiyorusunuz......");

                    Thread.sleep(4000);

                    islemSec();

                    break;


                }

            }
        } while (true);









    }

}

public static  void adminIslemSec() throws InterruptedException {

        Scanner scan=new Scanner(System.in);
    System.out.println("Lütfen yapmak istediðiniz iþlemiz seçiniz : \n1-Öðrenci Ekleme\n2-Öðrenci Bilgilerini Getirme\n3-Öðrenci Silme");

    int islem3= scan.nextInt();

    switch (islem3){

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

            System.out.println("Hatalý iþlem girdiniz seçim ekranýna gidiyorsunuz");

            islemSec();



    }

}

}
