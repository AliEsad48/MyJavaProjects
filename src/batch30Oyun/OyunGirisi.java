package batch30Oyun;

import java.util.*;

public class OyunGirisi {



    static List <Integer>paraListesi=new ArrayList<>();
    static Kutular kutular=new Kutular();

    public static void main(String[] args) {

        paraListesi.addAll(Arrays.asList(1,10,500,1000,5000,10000,50000,100000,250000,500000));

        Collections.shuffle(paraListesi);

        for (int i = 0; i < paraListesi.size(); i++) {

            int kutuNo=i+1;

            Kutu kutu=new Kutu(kutuNo,paraListesi.get(i));

            kutular.kutuEkle(kutu);


        }

    }

}
