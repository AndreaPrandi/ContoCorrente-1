package it.betacom.model;

import java.time.LocalDate;

public class ContoCorrente extends Conto {
	
	public ContoCorrente(String Titolare, String Data) {
		super(Titolare, Data);
		this.interessi = new CalcoloInteressi(0.05, this);
		// TODO Auto-generated constructor stub
	}
	
	public void prelievo(int cifra, String data) {
		LocalDate Data = LocalDate.parse(data);
		this.interessi.generaInteressi(Data, 0);
		super.prelievo(cifra, data);
		
	}
	
	public void versamento(int cifra, String data) {
		LocalDate Data = LocalDate.parse(data);
		this.interessi.generaInteressi(Data, 0);
		super.versamento(cifra, data);
		
	}
}
