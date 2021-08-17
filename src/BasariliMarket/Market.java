package BasariliMarket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Market {
    
    
    /* Basrili Market alýþ-veriþ programý.
     *{d,p,...l} {2.10,3.20....0.50}
     * 1. Adým: Ürünler ve fiyatlarý içeren listeleri oluþturunuz.
     *          No     Ürün         Fiyat
               ====  =======        =========
                00   Domates         2.10 TL
                01   Patates         3.20 TL
                02   Biber           1.50 TL
                03   Soðan          2.30 TL
                04   Havuç              3.10 TL
                05   Elma            1.20 TL
                06   Muz             1.90 TL
                07   Çilek              6.10 TL
                08   Kavun           4.30 TL
                09   Üzüm              2.70 TL
                10   Limon           0.50 TL
     * 2. Adým: Kullanýcýnýn ürün nosuna göre listeden ürün seçmesini isteyiniz.
     * 3. Adým: Kaç kg satýn almak istediðini sorunuz.
     * 4. Adým: Alýnacak bu ürünü sepete ekleyiniz ve Sepeti yazdýrýnýz.
     * 5. Baþka bir ürün alýp almak istemediðini sorunuz.
     * 6. Eðer devam etmek istiyorsa yeniden ürün seçme kýsmýna yönlendiriniz.
     * 7. Eðer bitirmek istiyorsa ödeme kýsmýna geçiniz ve ödeme sonrasýnda programý bitiriniz
     */
    
    public static List<String> urunler=new ArrayList();
    public static List<Double> fiyatlar=new ArrayList();
    public static List<String>sepettekiUrunler=new ArrayList();
    public static List<Double>sepettekiFiyat=new ArrayList();
    public static List<Double>sepettekiKilo=new ArrayList();
    
    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);
        urunler.addAll(Arrays.asList("Domates","Patates","Biber","Soðan","Havuç","Elma","Muz","Cilek","Kavun","Uzum","Limon"));
        fiyatlar.addAll(Arrays.asList(2.1,3.2,1.5,2.3,3.1,1.2,1.9,6.1,4.3,2.7,0.5));
        int urunNo;
        double kg=0;
        String devam;
        double toplam=0;
        
        
        do {
        urunleriListele();
        System.out.println("Almak istediðiniz urunun numarasýný girin");
        urunNo=scan.nextInt();
        System.out.println("kaç kilo almak istiyorsunuz");
        kg=scan.nextDouble();
        sepeteEkle(urunNo,kg);
        toplam=sepetiYazdýr();
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
            
        System.out.println("Ne kadar paranýz var");
        miktar+=scan.nextDouble();
        if (miktar<toplam) {
            System.out.println("Paranýz yetersiz, ekleme yapýn");
            System.out.println("ekleme yapacaðýnýz miktar= "+(toplam-miktar));
        }
        }while(miktar<=toplam);
        System.out.println("----------------------------------------------------");
        System.out.println("þu ana kadar"+ miktar +" kadar odeme yaptýnýz");
        System.out.println("toplam borcunuz "+toplam);
        System.out.println("--------------------------------------------------");
        
        System.out.println("para üstünüz= "+(miktar-toplam));
        System.out.println("Bizi tercih ettiðiniz için teþekkürler");
        
    }
    public static double sepetiYazdýr() {
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