package yatzoo;

import java.util.List;

import Hjelpeklasser.Spiller;
import Hjelpeklasser.Terning;

public class Yatzoo {
	List<Spiller> spillere;
	Runder runder = new Runder();

	public Yatzoo(List<Spiller> spillerlist) {
		spillere = spillerlist;
	}
	public List<Spiller> getSpillere(){
		return spillere;
	}
	
	public List<Terning> getTerning(){
		return runder.getAktiveT();
	}

	/*
	 * metoden som starter spillet og kjører gjennom alle rundene ved bruk av en forløkke.
	 */
	public void start() {
		int poeng;
		for (int runde = 1; runde <= 12; runde++) {
			System.out.println("-------------------------------------");
			System.out.println("Runde " + runde);
			System.out.println("-------------------------------------");

			
			if (runde <= 6) { 
				 for(int y = 0; y < spillere.size(); y++) {
				 runder = new Runder(); //resetter terninger for hver spiller/runde.
				 poeng = runder.antallDyr(runde); 
				 spillere.get(y).setPoeng(spillere.get(y).getPoeng() + poeng);
				 System.out.println(spillere.get(y).getNavn() + " fikk: " + poeng + " poeng");
				 }
			} else if (runde == 7 || runde == 8) {
				for (int y = 0; y < spillere.size(); y++) {
					runder = new Runder();
					 poeng = runder.antallLike(runde - 4);
					 spillere.get(y).setPoeng(spillere.get(y).getPoeng() + poeng);
					 System.out.println(spillere.get(y).getNavn() + " fikk: " + poeng + " poeng");
				}
			} else if (runde == 9) {
				for(int y = 0; y < spillere.size(); y++) {
					runder = new Runder();
					poeng = runder.toPar();
					spillere.get(y).setPoeng(spillere.get(y).getPoeng() + poeng);
					System.out.println(spillere.get(y).getNavn() + " fikk: " + poeng + " poeng");
		
				}
			} else if (runde == 10) {
				for(int y = 0; y < spillere.size(); y++) {
					runder = new Runder();
					poeng = runder.hus();
					spillere.get(y).setPoeng(spillere.get(y).getPoeng() + poeng);
					System.out.println(spillere.get(y).getNavn() + " fikk: " + poeng + " poeng");
	
				}
			} else if (runde == 11) {
				for(int y = 0; y < spillere.size(); y++) {
					runder = new Runder();
					poeng = runder.ulike();
					spillere.get(y).setPoeng(spillere.get(y).getPoeng() + poeng);
					System.out.println(spillere.get(y).getNavn() + " fikk: " + poeng + " poeng");

				}
			} else if (runde == 12) {
				for(int y = 0; y < spillere.size(); y++) {
					runder = new Runder();
					poeng = runder.alleLik();
					spillere.get(y).setPoeng(spillere.get(y).getPoeng() + poeng);
					System.out.println(spillere.get(y).getNavn() + " fikk: " + poeng + " poeng");
				}
				System.out.println("-------------------------------------");
				System.out.println("Spillet ferdig, spillernes poengsummer er:");
				for(int y = 0; y < spillere.size(); y++) {
					System.out.println(spillere.get(y).getNavn() + " fikk: " + spillere.get(y).getPoeng());	
				}
			}
		}
	}	
}