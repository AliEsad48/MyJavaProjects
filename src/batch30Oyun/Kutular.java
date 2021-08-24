package batch30Oyun;

import java.util.ArrayList;
import java.util.List;

public class Kutular {

    /*

    --public void kutuEkle(Kutu kutu)
	 		--public void kutuActir(int kutuNumarasi)
	 		--public int kalanKutuSayisi()
	 		--public int kutulardakiToplamParaMiktari()
	 		--public void secilenKutuyuKutularListesindenKaldır()
	 		public void yapimcininTeklifiniAl()
	 		public String acilmamisKutularıGoster()
	 		public void kaybedilenTutarlar()

    */

    List <Kutu> kutuListesi=new ArrayList<>();

    public void kutuEkle(Kutu kutu){

        kutuListesi.add(kutu);

    }

    public void kutuActir(int kutuNumarasi){

        for (Kutu k:kutuListesi) {

            if (kutuNumarasi == k.getKutuNumarasi()) {

                System.out.println("Kutudaki Miktar = " + k.getParaMiktari());

                kutuListesi.remove(k);
                break;

            }

        }

    }

    public int kalanKutuSayisi(){

        return kutuListesi.size();

    }

    public int kutulardakiToplamParaMiktari(){


        int paraMiktari =0;
        for (Kutu w : kutuListesi) {
            paraMiktari+=w.getParaMiktari();
        }
        return paraMiktari;
    }

    public void secilenKutuyuKutularListesindenKaldır(){



    }

}


