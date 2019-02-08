package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Hjelpeklasser.Spiller;
import Hjelpeklasser.Terning;
import yatzoo.Yatzoo;


class tester {

	List<Spiller> spillere = new ArrayList<Spiller>();
	Spiller p1 = new Spiller("Torkel");
	Spiller p2 = new Spiller("Johanne");
	Spiller p3 = new Spiller("Karin");
	Spiller p4 = new Spiller("Jocef");
	Spiller p5 = new Spiller("Helene");

	//legger til i spillerlisten

	@Test
	void testSpillere() {
		spillere.add(p1);
		spillere.add(p2);
		spillere.add(p3);
		spillere.add(p4);
		spillere.add(p5);
		Yatzoo Spill = new Yatzoo(spillere);
		assertTrue(Spill.getSpillere().size() == 5);
	}
	
	@Test
	void testTerninger() {
		spillere.add(p1);
		spillere.add(p2);
		spillere.add(p3);
		spillere.add(p4);
		spillere.add(p5);
		Yatzoo Spill = new Yatzoo(spillere);
		List<Terning> T = Spill.getTerning();
		assertTrue(T.size() == 5);
		for(int i = 0; i < T.size(); i++ ) {
			T.get(i).trill();
			if(T.get(i).getVerdi() < 7 && T.get(i).getVerdi() > 0) {
				assertTrue(true);
			}
		}
	}
}
