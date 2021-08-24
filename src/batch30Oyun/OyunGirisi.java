package batch30Oyun;

import java.util.*;

public class OyunGirisi<satatic> {



    static List <Integer>paraListesi=new ArrayList<>();
    static Kutular kutular=new Kutular();
    static Scanner scan=new Scanner(System.in);
    static int kutuNumaram;
    static int paraMiktarim;

    public static void main(String[] args) {

        paraListesi.addAll(Arrays.asList(1,10,500,1000,5000,10000,50000,100000,250000,500000));

        Collections.shuffle(paraListesi);

        for (int i = 0; i < paraListesi.size(); i++) {

            int kutuNo=i+1;

            Kutu kutu=new Kutu(kutuNo,paraListesi.get(i));

            kutular.kutuEkle(kutu);


        }

        System.out.print("Oyunumuza Ho� Geldiniz\nL�tfen Bir Kutu Se�in : ");

        kutuNumaram=scan.nextInt();

        paraMiktarim=paraListesi.get(kutuNumaram-1);

        kutular.secilenKutuyuKutularListesindenKaldir(kutuNumaram);

        kutuSecmeActirma();
    }

    public static void kutuSecmeActirma(){

        System.out.println("Kalan Kutular : " + kutular.acilmamisKutulariGoster());

        System.out.print("Hangi Kutuyu A�mak �stersiniz : ");

        int secim=scan.nextInt();
        kutular.kutuActir(secim);
        if (kutular.kalanKutuSayisi() == 7|| kutular.kalanKutuSayisi()==4||kutular.kalanKutuSayisi()==1) {

            System.out.println("Teklifimiz : " + kutular.yapimcininTeklifiniAl(paraMiktarim));
            System.out.println("Teklifi Kabul Ediyor Musun(1-Evet 2-Hay�r)");
            int yanit=scan.nextInt();
            if(yanit==1){
                System.out.println("Oyun Bitti");
                System.out.println("Kazan�lan Miktar : " + kutular.yapimcininTeklifiniAl(paraMiktarim));
                System.out.println("Kendi Kutunuzdaki Miktar : " + paraMiktarim);
            }else {

                kutuSecmeActirma();

            }

        }else{

            if (kutular.kalanKutuSayisi()>0) {
                kutuSecmeActirma();
            }else {
                System.out.println("Oyun Bitti");
                System.out.println("Kutunuzdaki Miktar : " + paraMiktarim);

            }

        }

    }

}
