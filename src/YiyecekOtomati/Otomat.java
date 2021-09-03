package YiyecekOtomati;

/*
Merhaba arkada�lar, javadan proje yapmak isteyen arkada�lar vard�...
projemizin ad� YIYECEK OTOMATI

--15 adet �r�n ve bu �r�nlerin fiyatlar�n� belirleyiniz.
Bu �r�nler ekranda listelensin

--�r�n se�ip, para miktar� giriniz
--girdi�iniz para fazla ise �st�n� versin,
eksik ise ekleme yapman�z� istesin
--Ek �r�n se�me se�ene�i olsun, siz devam etti�iniz s�rece,
para kontrol�n� de yaparak i�lem yapmaya devam etsin...
NOT: Otomat sadece 1 tl , 5 tl, 10 tl, 20 tl miktarlar�n� kabul etsin
oop concepte ait ��rendiklerimizi kullanmaya �al��al�m...

iyi �al��malar
Kolay gelsin...
*/

import java.util.*;

public class Otomat {

    String urun = "";
    Integer urunBedeli = 0;
    static Byte urunKodu = 0;
    static private String otomatSifre = "1453";
    static HashMap<Byte, List<Otomat>> otomat = new HashMap<>();
    static Scanner scan = new Scanner(System.in);

    public Otomat(String urun, Integer urunBedeli) {

        this.urun = urun;
        this.urunBedeli = urunBedeli;
    }

    public static void main(String[] args) throws InterruptedException {

        menu();
    }

    private static void menu() throws InterruptedException {

        String islem = "";

        do {
            System.out.println("JAVA OTOMATA HOS GELDINIZ.");
            System.out.println("--------------------------");
            System.out.println("1- Urun Ekle");
            System.out.println("2- Urun Satin Al");
            System.out.println("3- Cikis");

            islem = scan.nextLine();

            switch (islem) {
                case "1":
                    urunEkle();
                    break;
                case "2":
                    urunAl();
                    break;
                case "3":
                    System.out.println("Iyi gunler dileriz...");
                    break;
                default:
                    System.out.println("Lutfen sunulan seceneklerden birini secin!");
                    break;
            }
        } while (!islem.equals("3"));

    }

    private static void urunAl() throws InterruptedException {

        Integer tutar = 0;
        char islem = ' ';
        int musteriPara = 0;
        int eksiktutar = 0;
        byte kod = 0;

        if (otomat.isEmpty()) {

            System.out.println(
                    "Su anda otomatta urun bulunmamaktadir. En kisa surede hizmetinize acilacaktir! Anlayisiniz icin tesekkurler.");
            Thread.sleep(2000);
        } else {

            do {

                for (Map.Entry<Byte, List<Otomat>> w : otomat.entrySet()) {

                    System.out.println(w.getKey() + " " + w.getValue());
                }

                System.out.println("Lutfen almak istediginiz urunun kodunu giriniz. Geri donmek icin 0'a basiniz");
                kod = scan.nextByte();
                scan.nextLine();
                if (otomat.containsKey(kod)) {
                    System.out.println("Almak istediginiz urun: " + otomat.get(kod));
                    List<Otomat> urunBilgileri = otomat.get(kod);
                    tutar += urunBilgileri.get(0).urunBedeli;
                    System.out.println("Baska bir urun almak istiyor musunuz? (E/H)");
                    islem = scan.next().toUpperCase().charAt(0);

                } else {
                    if (kod != 0) {

                        System.out.println("Bu kodda herhangi bir urun bulunamadi. Lutfen tekrar deneyiniz.");
                    } else {
                        System.out.println("Ust menuye yonlendiriliyorsunuz...");
                        Thread.sleep(1000);
                    }
                }
            } while (islem != 'H' && kod != 0);

            if (kod != 0) {
                System.out.println("Odemeniz gereken tutar: " + tutar);
                System.out.println("Otomatimizda kullanmaniz gereken para tutarlari 1? 5? 10? 20?");
                eksiktutar = tutar;
                do {
                    System.out.println("Lutfen paranizi para giris bolmesinden atiniz");
                    int para = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Paraniz kontrol ediliyor...");
                    Thread.sleep(1500);
                    if (para == 1 || para == 5 || para == 10 || para == 20) {
                        musteriPara += para;
                        if (musteriPara >= tutar) {
                            musteriPara -= tutar;
                            tutar = 0;
                            System.out.println("Para ustunuz " + musteriPara + "?");
                            System.out.println(
                                    "Urununuzu alt bolmeden alabilirsiniz. Para ustunuzu almayi unutmayin! Iyi gunler dileriz");
                            Thread.sleep(3000);
                        } else {

                            eksiktutar -= para;
                            System.out.println(
                                    "Eksik tutar yuklediniz. " + eksiktutar + "? daha yuklemeniz gerekmektedir.");
                        }
                    } else {
                        System.out.println(
                                "Lutfen yalnizca kabul edilen para tutarlarini kullaniniz. Otomatimizda kullanmaniz gereken para tutarlari 1? 5? 10? 20? Odemeniz gereken tutar: "
                                        + eksiktutar);
                    }
                } while (musteriPara < tutar);

            }
        }
    }

    private static void urunEkle() throws InterruptedException {

        System.out.println("Urun ekleme menusune hos geldiniz.");
        byte sifreHak = 3;
        char islem = ' ';

        while (sifreHak != 0) {
            System.out.println("Devam etmek icin lutfen otomat sifresini giriniz: \nKadan deneme hakki: " + sifreHak);
            String sifre = scan.nextLine();
            System.out.println("Sifreniz kontrol ediliyor...");
            Thread.sleep(2000);
            if (sifre.equals(otomatSifre)) {
                sifreHak = 0;
                do {
                    System.out.println("Lutfen eklemek istediginiz urunu girin: ");
                    String urun = scan.nextLine();
                    System.out.println("Lutfen urunun satis fiyatini girin: ");
                    Integer satisFiyati = scan.nextInt();
                    Otomat o = new Otomat(urun, satisFiyati);
                    List<Otomat> urunler = new ArrayList<>();
                    urunler.add(o);
                    otomat.put(++urunKodu, urunler);
                    System.out.println("Urunler ekleniyor...");
                    Thread.sleep(2000);
                    System.out.println(otomat.get(urunKodu) + "\nUrun ve bilgileri basariyla eklendi");
                    System.out.println("Baska bir urun eklemek istiyor musunuz? (E/H)");
                    islem = scan.next().toUpperCase().charAt(0);
                    scan.nextLine();
                } while (islem != 'H');
            } else {
                System.out.println("Yanlis sifre girdiniz. Lutfen tekrar deneyin.");
                sifreHak--;
            }

        }
        if (sifreHak == 0) {
            System.out.println("Ust menuye yonlendiriliyorsunuz...");
            Thread.sleep(1000);
        }

    }

    @Override
    public String toString() {
        return urun + " " + urunBedeli + "?";
    }
}