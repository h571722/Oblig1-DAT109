package yatzoo;

import java.util.ArrayList;
import java.util.List;

import Hjelpeklasser.Spiller;
public class Start {

	/*
	 * Klassen som instansierer spillerene og starter spillet.
	 */
	public static void main(String[] args) {
		List<Spiller> spillere = new ArrayList<Spiller>();
		Spiller p1 = new Spiller("Torkel");
		Spiller p2 = new Spiller("Johanne");
		Spiller p3 = new Spiller("Karin");
		Spiller p4 = new Spiller("Jocef");
		Spiller p5 = new Spiller("Helene");
		
		//legger til i spillerlisten
		spillere.add(p1);
		spillere.add(p2);
		spillere.add(p3);
		spillere.add(p4);
		spillere.add(p5);
		
		Yatzoo startSpill = new Yatzoo(spillere);
		startSpill.start();
		
	}

}
