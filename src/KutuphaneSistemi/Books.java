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

        System.out.print("Lütfen eklemek istediðiniz kitabýn adýný giriniz : ");

        this.bookName=scan.nextLine();

        System.out.print("Lütfen eklemek istediðiniz kitabýn yazarýný giriniz : ");

        this.authorName=scan.nextLine();

        System.out.print("Lütfen eklmek istediðiniz kitabýn sayfa sayýsýnýz giriniz : ");

        this.page= scan.nextInt();

        setbookId();


    }



    public String toString(){

        return "Kitabýn Adý : " + bookName + "\nKitabýn Yazarý : " + authorName + "\nKitabýn Sayfa Sayýsý : " + page + "\nKitabýn id si : " + bookId;

    }

    static Map<String , String> kitapBilgileri=new HashMap<>();

    public static void mapeKitapEkle(){

        Scanner scan=new Scanner(System.in);

        String stop="";

        while (!stop.equalsIgnoreCase("dur")) {
            Books b=new Books();



            kitapBilgileri.put(b.bookId , b.toString());

            System.out.println("Ýþlemleri bitirmek için dur yazýnýz\nDevam etmek için entera basýnýz");

            stop= scan.nextLine();
        }

        islemSec();

    }

    public static void getBookInfo(){

        Scanner scan=new Scanner(System.in);

        String kitabinIdsi="";

        String sonuc="";

        do {
            System.out.println("Lütfen kitabýn bilgilerini almak için idsini giriniz");
            System.out.println("Programý bitirmek için çýkýþ yazýnýz");

            kitabinIdsi =scan.nextLine();

            sonuc = kitapBilgileri.get(kitabinIdsi);

            if (!kitabinIdsi.equalsIgnoreCase("çýkýþ")) {

                System.out.println(sonuc);

            }

        }while (!kitabinIdsi.equalsIgnoreCase("çýkýþ"));

        islemSec();

    }

    public static void kitapSil(){

        Scanner scan=new Scanner(System.in);

        String kitabinIdsi="";

        String sonuc="";

        do {
            System.out.println("Lütfen kitabý silmek için idsini giriniz");
            System.out.println("Programý bitirmek için çýkýþ yazýnýz");

            kitabinIdsi =scan.nextLine();

            sonuc = kitapBilgileri.remove(kitabinIdsi);

            if (!kitabinIdsi.equalsIgnoreCase("çýkýþ")) {

                System.out.println(sonuc);

                System.out.println("Kitab listeden silindi");

            }

        }while (!kitabinIdsi.equalsIgnoreCase("çýkýþ"));

        islemSec();

    }

    public static void islemSec() {

        System.out.println("Ýþlem seçin:\n1-Kitap Ekleme\n2-Kitabýn bilgilerini getirme\n3-Kitbýn bilgilerini silme");

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
                System.out.println("Yanlýþ iþlem girdiniz 1,2 ya da 3 giriniz");
                islemSec();
                break;

        }

        islemSec();

    }

}
