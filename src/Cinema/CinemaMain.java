package Cinema;

import java.util.Arrays;
import java.util.Scanner;

public class CinemaMain {

	static Scanner scan = new Scanner(System.in);

	static int dummyCount = 0;

	public static void main(String[] args) {

		Cinema.filmler.addAll(Arrays.asList("Shrek", "Görevimiz Tehlike", "Testere"));
		Cinema.saat.addAll(Arrays.asList("12.30", "15.00", "21.00"));
		Cinema.yasSinir.addAll(Arrays.asList("Genel Ýzleyici Kitlesi Ýçin Uygundur",
				"Þiddet Ve Korku Ögeleri Ýçermektedir", "18 yaþ ve üzeri içindir"));
		Cinema.fiyat.addAll(Arrays.asList(28.50, 32.25, 25.50));

		System.out.println(
				"Java Cinema ya Hoþ Geldiniz Lütfen Yapmak Ýstediðiniz iþlemi Seçiniz ...\n1-Bilet Ekraný\n2-Film Ekleme\n3-Çýkýþ");

		int islem = scan.nextInt();

		scan.nextLine();

		while (islem != 1 && islem != 2 && islem != 3) {

			System.out.println("-------------------------------------------");
			System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz!");

			System.out.println("-------------------------------------------\n\n");

			System.out.println(
					"Lütfen Yapmak Ýstediðiniz iþlemi Seçiniz ...\n1-Bilet Ekraný\\n2-Film Ekleme\\n3-Çýkýþ\");\r\n");
			islem = scan.nextInt();

		}

		if (islem == 1) {
			biletEkrani();

		} else if (islem == 2) {

			filmEkleme1();

		} else {

			cikis();

		}

	}

	private static void cikis() {
		System.out.println("-------------------------------------------");

		System.out.println("Cikis yapiliyor...\nBizi tercih ettiginiz icin tesekkur ederiz");

		System.out.println("-------------------------------------------\n\n");

	}

	private static void biletEkrani() {

		dummyCount++;

		Cinema film = new Cinema();

		System.out.println("Bilet Ekranýndasýnýz \nFilmlere bakmak için 1 \nÇýkýþ için 2 yazýnýz");

		int islem2 = scan.nextInt();

		while (islem2 != 1 && islem2 != 2) {

			System.out.println("-------------------------------------------");
			System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz!");

			System.out.println("-------------------------------------------\n\n");

			System.out.println("Bilet Ekranýndasýnýz \nFilmlere bakmak için 1 \nÇýkýþ için 2 yazýnýz");

			islem2 = scan.nextInt();

		}

		if (islem2 == 1) {

			String devam;
			double toplam;
			do {
				film.filmleriListele();
				System.out.println("Lutfen bilet almak istediðiniz filmin numarasini giriniz...");
				int filmNo = scan.nextInt();
				System.out.println("Guzel secim, kac kaç kiþisiniz");
				double kisi = scan.nextDouble();
				film.filmSec(filmNo, kisi);
				toplam = film.secilenFilmler();
				System.out.println();
				System.out.println("devam etmek istiyor musunuz(E/H)");
				devam = scan.next();
			} while (devam.equalsIgnoreCase("E"));

			odeme(toplam);

		} else if (islem2 == 2) {
			cikis();

		}

	}

	private static void odeme(double toplam) {
		System.out.println("--------------------------------------------");
		System.out.println("Odemeniz gereken Tutar= " + toplam + "$");
		System.out.println("------------------------------------------");
		System.out.println("Odeme yapmak icin herhangi bir tusa basiniz...");
		String secim4 = scan.next();

		System.out.println("Odemeniz gayet basarili yine bekleriz :)\n\n");
		cikis();

	}

	public static void filmEkleme1() {
		if (dummyCount > 0) {
			scan.nextLine();
		}
		Cinema film = new Cinema();
		System.out.println("Film Ekleme paneline hos geldin !\n\n");
		String sifre = "";// while sartimda kullanmak icin initalize ediyorum bunun ne atadigimin onemi
							// yok while sartimda atama yapiyorum zaten.
		String admin = "";
		int secim3 = 0;
		int count = 5; // Kullanicima 5 tane deneme hakki veriyorum.

		do {

			System.out.println("Lutfen giris icin kullanici adinizi giriniz...");

			admin = scan.nextLine();

			System.out.println("Lutfen sifrenizi giriniz...");
			sifre = scan.nextLine();
			if (((!sifre.equals(film.getSifre())) || (!admin.equals(film.getAdmin())))) {
				count--;
				if (count == 0) {
					System.out
							.println("5 Yanlis tuslama yaptiniz !\nDeneme hakkiniz kalmadi sistemden atiliyorsunuz !");
					cikis();
				} else {
					System.out.println(
							"Yanlis tuslama yaptiniz lutfen tekrar deneyiniz !\nKalan deneme hakkiniz --> " + count);
				}

			}

		} while ((((!sifre.equals(film.getSifre())) || (!admin.equals(film.getAdmin()))) && count != 0));
		// kodumuz buraya gelirse kullanici adini ve sifreyi dogru girmis demektir.
		System.out.println("\n--------------------------------------------------");
		System.out.println("Sisteme girisiniz gayet basarili ");
		System.out.println("--------------------------------------------------\n");

		System.out.println(
				"Lutfen yapmak istediginiz islemi seciniz...\n1-Film ekle\n2-Onizleme(Musteri giris)\n3-Cikis");
		int secim2 = scan.nextInt();
		scan.nextLine();
		while (secim2 != 1 && secim2 != 2 && secim2 != 3) {
			System.out.println("-------------------------------------------");

			System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz!");

			System.out.println("-------------------------------------------\n\n");
			System.out.println(
					"Lutfen hangi islemi yapmak istiyorsani onu isaretleyiniz...\n1-Film ekle\n2-Onizleme(Musteri giris)\n3-Cikis");
			secim2 = scan.nextInt();
		}

		if (secim2 == 1) {
			String devamMi;
			do {
				System.out.println("Film ekleme bolumdesiniz !\n");
				System.out.println("Lutfen filmin adýný giriniz...");
				Cinema.filmler.add(scan.nextLine());
				System.out.println("Lutfen filmin saatini giriniz...");
				Cinema.saat.add(scan.nextLine());
				System.out.println("Lutfen filmin yaþ sýnýrýný giriniz...");
				Cinema.yasSinir.add(scan.nextLine());
				scan.nextLine();
				System.out.println("Lutfen filmin fiyatýný giriniz...");
				Cinema.fiyat.add(scan.nextDouble());

				System.out.println(
						"\nFilm ekleme tamamlandi !\nDevam etmek istiyor musunuz? Evet icin 'E' Hayir icin 'H'");
				devamMi = scan.next();
				scan.nextLine();

			} while (devamMi.equalsIgnoreCase("E"));
			System.out.println(
					"\nFilm eklemeden basariyla cikildi\n\nLutfen yapmak istediginiz islemi seciniz...\n1-Onizleme(Musteri giris)\n2-Cikis");
			secim3 = scan.nextInt();

			while (secim3 != 1 && secim3 != 2) {
				System.out.println("-------------------------------------------");

				System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz!");

				System.out.println("-------------------------------------------\n\n");
				System.out.println(
						"Lutfen hangi islemi yapmak istiyorsani onu isaretleyiniz...\n1-Film ekle\n2-Onizleme(Musteri giris)\n3-Cikis");
				secim3 = scan.nextInt();
			}

		}
		if (secim2 == 2 || secim3 == 1) {
			biletEkrani();

		}
		if (secim2 == 3 || secim3 == 2) {
			cikis();
		}

	}

}
											