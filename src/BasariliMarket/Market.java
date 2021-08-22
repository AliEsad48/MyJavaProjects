package BasariliMarket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Market {
    
    
    /* Basrili Market al��-veri� program�.
     *{d,p,...l} {2.10,3.20....0.50}
     * 1. Ad�m: �r�nler ve fiyatlar� i�eren listeleri olu�turunuz.
     *          No     �r�n         Fiyat
               ====  =======        =========
                00   Domates         2.10 TL
                01   Patates         3.20 TL
                02   Biber           1.50 TL
                03   So�an          2.30 TL
                04   Havu�              3.10 TL
                05   Elma            1.20 TL
                06   Muz             1.90 TL
                07   �ilek              6.10 TL
                08   Kavun           4.30 TL
                09   �z�m              2.70 TL
                10   Limon           0.50 TL
     * 2. Ad�m: Kullan�c�n�n �r�n nosuna g�re listeden �r�n se�mesini isteyiniz.
     * 3. Ad�m: Ka� kg sat�n almak istedi�ini sorunuz.
     * 4. Ad�m: Al�nacak bu �r�n� sepete ekleyiniz ve Sepeti yazd�r�n�z.
     * 5. Ba�ka bir �r�n al�p almak istemedi�ini sorunuz.
     * 6. E�er devam etmek istiyorsa yeniden �r�n se�me k�sm�na y�nlendiriniz.
     * 7. E�er bitirmek istiyorsa �deme k�sm�na ge�iniz ve �deme sonras�nda program� bitiriniz
     */
    
    public static List<String> urunler=new ArrayList();
    public static List<Double> fiyatlar=new ArrayList();
    public static List<String>sepettekiUrunler=new ArrayList();
    public static List<Double>sepettekiFiyat=new ArrayList();
    public static List<Double>sepettekiKilo=new ArrayList();
    
    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);
        urunler.addAll(Arrays.asList("Domates","Patates","Biber","So�an","Havu�","Elma","Muz","Cilek","Kavun","Uzum","Limon"));
        fiyatlar.addAll(Arrays.asList(2.1,3.2,1.5,2.3,3.1,1.2,1.9,6.1,4.3,2.7,0.5));
        int urunNo;
        double kg=0;
        String devam;
        double toplam=0;
        
        
        do {
        urunleriListele();
        System.out.println("Almak istedi�iniz urunun numaras�n� girin");
        urunNo=scan.nextInt();
        System.out.println("ka� kilo almak istiyorsunuz");
        kg=scan.nextDouble();
        sepeteEkle(urunNo,kg);
        toplam=sepetiYazdir();
        System.out.println();
        System.out.println("devam etmek istiyor musunuz(E/H)");
        devam=scan.next();
        }while (devam.equalsIgnoreCase("E"));
        
        odemeYap(toplam);
        
        }
    
    public static void odemeYap(double toplam) {
        Scanner scan=new Scanner(System.in);
        double miktar=0;
        System.out.println("--------------------------------------------");
        System.out.println("odemeniz gereken miktar= "+toplam);
        System.out.println("------------------------------------------");
        
        do {
            
        System.out.println("Ne kadar paran�z var");
        miktar+=scan.nextDouble();
        if (miktar<toplam) {
            System.out.println("Paran�z yetersiz, ekleme yap�n");
            System.out.println("ekleme yapaca��n�z miktar= "+(toplam-miktar));
        }
        }while(miktar<=toplam);
        System.out.println("----------------------------------------------------");
        System.out.println("�u ana kadar"+ miktar +" kadar odeme yapt�n�z");
        System.out.println("toplam borcunuz "+toplam);
        System.out.println("--------------------------------------------------");
        
        System.out.println("para �st�n�z= "+(miktar-toplam));
        System.out.println("Bizi tercih etti�iniz i�in te�ekk�rler");
        
    }
    public static double sepetiYazdir() {
        double sepettekiToplam=0;
        System.out.println("URUNADI\tKILO\tTUTAR");
        System.out.println("------------------------------------------");
        for (int i=0;i<sepettekiUrunler.size();i++) {
            
            System.out.println(sepettekiUrunler.get(i)+"\t"+sepettekiKilo.get(i)+"\t"+sepettekiFiyat.get(i));
            sepettekiToplam+=sepettekiFiyat.get(i);
                    
        }
        
        return sepettekiToplam;
        
        
    }
    public static void sepeteEkle(int urunNo, double kg) {
        
        sepettekiUrunler.add(urunler.get(urunNo));
        sepettekiKilo.add(kg);
        sepettekiFiyat.add(fiyatlar.get(urunNo)*kg);
        
        
    }
    public static void urunleriListele() {  
        
        System.out.println("NO\tURUNLER\t\tFIYATLAR");
        System.out.println("-------------------------------------------------------------");
        
        for (int i=0; i<urunler.size(); i++) {
                        
            System.out.println(i+"\t"+urunler.get(i)+"\t\t"+fiyatlar.get(i));
        }
        
    }
}