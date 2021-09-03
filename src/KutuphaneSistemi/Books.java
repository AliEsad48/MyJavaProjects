package KutuphaneSistemi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Books {

    private String bookName;

    private String authorName;

    private int page;

    private static int id=0;

    private String bookId;

    public void setbookId() {


        id++;
        this.bookId = page + "" + id;
    }

    public Books(){

        Scanner scan=new Scanner(System.in);

        System.out.print("L�tfen eklemek istedi�iniz kitab�n ad�n� giriniz : ");

        this.bookName=scan.nextLine();

        System.out.print("L�tfen eklemek istedi�iniz kitab�n yazar�n� giriniz : ");

        this.authorName=scan.nextLine();

        System.out.print("L�tfen eklmek istedi�iniz kitab�n sayfa say�s�n�z giriniz : ");

        this.page= scan.nextInt();

        setbookId();


    }



    public String toString(){

        return "Kitab�n Ad� : " + bookName + "\nKitab�n Yazar� : " + authorName + "\nKitab�n Sayfa Say�s� : " + page + "\nKitab�n id si : " + bookId;

    }

    static Map<String , String> kitapBilgileri=new HashMap<>();

    public static void mapeKitapEkle(){

        Scanner scan=new Scanner(System.in);

        String stop="";

        while (!stop.equalsIgnoreCase("dur")) {
            Books b=new Books();



            kitapBilgileri.put(b.bookId , b.toString());

            System.out.println("��lemleri bitirmek i�in dur yaz�n�z\nDevam etmek i�in entera bas�n�z");

            stop= scan.nextLine();
        }

        islemSec();

    }

    public static void getBookInfo(){

        Scanner scan=new Scanner(System.in);

        String kitabinIdsi="";

        String sonuc="";

        do {
            System.out.println("L�tfen kitab�n bilgilerini almak i�in idsini giriniz");
            System.out.println("Program� bitirmek i�in ��k�� yaz�n�z");

            kitabinIdsi =scan.nextLine();

            sonuc = kitapBilgileri.get(kitabinIdsi);

            if (!kitabinIdsi.equalsIgnoreCase("��k��")) {

                System.out.println(sonuc);

            }

        }while (!kitabinIdsi.equalsIgnoreCase("��k��"));

        islemSec();

    }

    public static void kitapSil(){

        Scanner scan=new Scanner(System.in);

        String kitabinIdsi="";

        String sonuc="";

        do {
            System.out.println("L�tfen kitab� silmek i�in idsini giriniz");
            System.out.println("Program� bitirmek i�in ��k�� yaz�n�z");

            kitabinIdsi =scan.nextLine();

            sonuc = kitapBilgileri.remove(kitabinIdsi);

            if (!kitabinIdsi.equalsIgnoreCase("��k��")) {

                System.out.println(sonuc);

                System.out.println("Kitab listeden silindi");

            }

        }while (!kitabinIdsi.equalsIgnoreCase("��k��"));

        islemSec();

    }

    public static void islemSec() {

        System.out.println("��lem se�in:\n1-Kitap Ekleme\n2-Kitab�n bilgilerini getirme\n3-Kitb�n bilgilerini silme");

        Scanner scan=new Scanner(System.in);

        int islem=scan.nextInt();

        switch (islem){

            case 1:

                mapeKitapEkle();
                break;

            case 2:

                getBookInfo();

                break;

            case 3:

                kitapSil();

                break;

            default:
                System.out.println("Yanl�� i�lem girdiniz 1,2 ya da 3 giriniz");
                islemSec();
                break;

        }

        islemSec();

    }

}
