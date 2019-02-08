package Hjelpeklasser;

import java.util.ArrayList;
import java.util.List;

public class Spiller {
	private String navn;
	private int Poeng;
	
	public Spiller(String navn) {
		this.navn = navn;
		
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getPoeng() {
		return Poeng;
	}

	public void setPoeng(int poeng) {
		Poeng = poeng;
	}
	
}
