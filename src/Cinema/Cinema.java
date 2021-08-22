package Cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

	public static List<String> filmler = new ArrayList<>();
	public static List<String> saat = new ArrayList<>();
	public static List<String> yasSinir = new ArrayList<>();
	public static List<Double> fiyat = new ArrayList<>();

	public static List<String> afilmler = new ArrayList<>();
	public static List<String> asaat = new ArrayList<>();
	public static List<String> ayasSinir = new ArrayList<>();
	public static List<Double> afiyat = new ArrayList<>();

	private static String admin = "admin";
	private static String sifre = "12345";

	Cinema() {

	}

	public static String getAdmin() {
		return admin;
	}

	public static String getSifre() {
		return sifre;
	}

	public void filmleriListele() {

		System.out.println("No\tFilm\t\tSaat\t\tYaþ Sýnýrý\t\tFiyat");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////");

		for (int i = 0; i < filmler.size(); i++) {

			System.out.println(i + "\t" + filmler.get(i) + "\t\t" + saat.get(i) + "\t\t" + yasSinir.get(i) + "\t\t"
					+ fiyat.get(i));

		}

	}

	public double secilenFilmler() {
		double toplamTutar = 0;
		System.out.println("NO\tFilm\t\tSaat\t\tYaþ Sýnýrý\t\tFiyat");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////");

		for (int i = 0; i < afilmler.size(); i++) {

			System.out.println(i + "\t" + afilmler.get(i) + "\t\t" + asaat.get(i) + "\t\t" + ayasSinir.get(i) + "\t\t"
					+ afiyat.get(i));
			toplamTutar += afiyat.get(i);
		}
		return toplamTutar;

	}

	public void filmSec(int filmNo, double kisiSayisi) {

		afilmler.add(filmler.get(filmNo));
		asaat.add(saat.get(filmNo));
		ayasSinir.add(yasSinir.get(filmNo));
		afiyat.add((fiyat.get(filmNo) * kisiSayisi));

	}
}
