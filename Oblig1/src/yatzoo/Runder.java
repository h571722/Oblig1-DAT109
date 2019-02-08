package yatzoo;

import java.util.ArrayList;
import java.util.List;

import Hjelpeklasser.Terning;

public class Runder {
	List<Terning> aktiveT = new ArrayList<Terning>();
	List<Terning> resultat = new ArrayList<Terning>();
	int[] frekvensTab = new int[7];
	int[] frekvensTab2 = new int[7];

	public Runder() {
		Terning t1 = new Terning();
		Terning t2 = new Terning();
		Terning t3 = new Terning();
		Terning t4 = new Terning();
		Terning t5 = new Terning();
		aktiveT.add(t1);
		aktiveT.add(t2);
		aktiveT.add(t3);
		aktiveT.add(t4);
		aktiveT.add(t5);
	}
	
	public List<Terning> getAktiveT(){
		return aktiveT;
	}

	/*
	 * Metode for runde 1-6 som teller antall dyr på terningenen. Rekkefølgen er
	 * Løve(1), Slange(2), Panda(3), Gris(4),Elefant(5), Hvaler(6)
	 * @param rundeNr
	 * @return
	 */
	public int antallDyr(int rundeNR) {
		int teller;
		for (int i = 1; i < 4; i++) { // tre kast per runde per spiller
//			System.out.println();
//			System.out.println("Kast: " + i);
			teller = 0;
			for (Terning t : aktiveT) {
				t.trill();
//				System.out.println(t.getVerdi());
				if (t.getVerdi() == rundeNR) {
					resultat.add(t);
					teller++;
				}
			}
			for (int j = 0; j < teller; j++) {
				aktiveT.remove(0);
			}
		}
		return resultat.size();
	}

	/*
	 * Hjelpemetode for å finne et forespurt antall like terninger. Som 3 eller 4 like.
	 * @param antall
	 * @return
	 */
	public int antallLike(int antall) {
		int flest = 0;
		int antallSlettet = 0;
		for (int i = 1; i < 4; i++) {
//			System.out.println();
//			System.out.println("Kast: " + i);
			for (Terning t : aktiveT) {
				t.trill();
//				System.out.print(t.getVerdi() + ", ");
				frekvensTab[t.getVerdi()]++;
			}
//			System.out.println();
			flest = flestLike(frekvensTab);
//			System.out.println("Sparer på: " + flest);
			fiksFtab(flest);

			// fjerner terninger vi legger til.
			while (antallSlettet < frekvensTab[flest]) {
				aktiveT.remove(0);
				antallSlettet++;
			}
		}
		if (frekvensTab[flest] >= antall) {
			return antall;
		}
		return 0;
	}

	/* Hjelpemetode som fungerer som en frekvenstabell.
	 * Den returnerer den indeksen hvor det forekommer flest like
	 * @param= fTab
	 * @return
	 */
	public int flestLike(int[] fTab) {
		int størst = fTab[1];
		int indeks = 1;
		for (int i = 2; i < 7; i++) {
			if (fTab[i] > størst) {
				størst = fTab[i];
				indeks = i;
			}
		}
		return indeks;
	}
	/* Hjelpemetode for å spare på det største i en frekvenstabell. 
	 * @param spar
	 * @return
	 */
	public void fiksFtab(int spar) {
		for (int i = 0; i < 7; i++) {
			if (i != spar) {
				frekvensTab[i] = 0;
			}
		}
	}
	
	/* Metoden for å finne ToPar(RundeNr 9)
	 * @return
	 */
	public int toPar() {
		int flest = 0;
		int[] parene = new int[2];
		for (int i = 1; i < 4; i++) {
//			System.out.println();
//			System.out.println("Kast: " + i);
			for (Terning t : aktiveT) {
				t.trill();
//				System.out.print(t.getVerdi() + ", ");
				frekvensTab[t.getVerdi()]++;
			}
//			System.out.println();
			for (int x = 0; x < 2; x++) {
				flest = flestLike(frekvensTab);
				if (frekvensTab[flest] >= 2) {
//					System.out.println("Fant ett par med verdi: " + flest);
					if (parene[0] > 0) {
						parene[1] = flest;
						return 4;
					} else {
						parene[0] = flest;
					}
					aktiveT.remove(0);
					aktiveT.remove(0);
					fjernITab(flest);
				}
			}
			fjernITab(flest);
			fiksFtab(flest);
		}
		return 0;
	}

	/* Hjelpemetode for å fjerne spesifikke elementer i en frekvenstabell
	 * @param fjern
	 * @return
	 */
	public void fjernITab(int fjern) {
		frekvensTab[fjern] = 0;
	}
	
	/* Metode for (Runde nr 10) Finner 3 og 2 like, altså Hus. 
	 * @return
	 */
	public int hus() {
		int flest = 0;
		boolean parFunnet = false;
		int[] parene = new int[3];
		for (int i = 1; i < 4; i++) {
//			System.out.println();
//			System.out.println("kast: " + i);
			for (int y = 0; y < aktiveT.size(); y++) {
				aktiveT.get(y).trill();
//				System.out.print(aktiveT.get(y).getVerdi() + ", ");
				frekvensTab[aktiveT.get(y).getVerdi()]++;
			}
//			System.out.println();
			if (!parFunnet) {
				for (int x = 0; x < 2; x++) {
					flest = flestLike(frekvensTab);
					if (frekvensTab[flest] >= 2) {
//						System.out.println("fant ett par med verdi: " + flest);
						if (parene[0] > 0 || parene[2] > 0) {
							parene[1] = flest;
							parFunnet = true;
							aktiveT.remove(0);
							aktiveT.remove(0);
							if (frekvensTab[flest] >= 3) {
								parene[1] = 0;
								parene[2] = flest;
								aktiveT.remove(0);
								return 5;
							}
							break;
						} else {
							parene[0] = flest;
							if (frekvensTab[flest] >= 3) {
								parene[0] = 0;
								parene[2] = flest;
								aktiveT.remove(0);
							}
						}
						aktiveT.remove(0);
						aktiveT.remove(0);
						fjernITab(flest);
					}
				}
				fjernITab(flest);
				fiksFtab(flest);
			}
			if (parFunnet) {
				if ((frekvensTab[0] == parene[0]) || (frekvensTab[0] == parene[1])) {
					return 5;
				}
			}
		}
		return 0;
	}

	/* Metode Rundenr 11. Sjekker om en spiller får 5 ulike verdier på 3 kast. 
	 * @return
	 */
	public int ulike() {
		int teller;
		for (int i = 1; i < 4; i++) {
//			System.out.println();
//			System.out.println("Kast: " + i);
			for (Terning t : aktiveT) {
				t.trill();
//				System.out.print(t.getVerdi() + ", ");
				frekvensTab[t.getVerdi()]++;
			}
//			System.out.println();
			fyllAktive();
			teller = 0;
			for (int x = 1; x < 7; x++) {
				if (frekvensTab[x] > 0) {
					frekvensTab[x] = 1;
					teller++;
					aktiveT.remove(0);
				}
				if (teller == 5) {
					return 5;
				}
			}
		}
		return 0;
	}

	/*Hjelpemetode som fyller opp igjen ative terninger. 
	 * @return
	 */
	public void fyllAktive() {
		while (aktiveT.size() < 5) {
			Terning t = new Terning();
			aktiveT.add(t);
		}

	}
	/* Metode for runde nr 12. Benytter seg av metoden for alle like. 
	 * @return
	 */
	public int alleLik() {
		return antallLike(5);
	}

}
