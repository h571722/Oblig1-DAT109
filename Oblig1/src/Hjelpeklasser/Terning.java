package Hjelpeklasser;

import java.util.Random;

public class Terning {
	private static final Random RAND = new Random();
	private Integer verdi;
	String dyret;
	
	public Terning () {
		
	}
	/*
	 * Metode for å "trille" terningene of
	 */
	public void trill() {
		verdi = RAND.nextInt(6) + 1;

		if(verdi == 1) {
			dyret = "løve";
		}else if(verdi == 2){
			dyret = "slange";
		}else if(verdi == 3) {
			dyret = "panda";
		}else if(verdi == 4){
			dyret = "gris";
		}else if(verdi == 5) {
			dyret = "elefant";
		}else{
			dyret = "hval";
		}

	}

	public int getVerdi() {
		return verdi;
	}
	
	@Override
	public String toString() {
		return dyret;
	}
	
}