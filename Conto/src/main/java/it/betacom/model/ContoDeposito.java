package it.betacom.model;

import java.time.LocalDate;

public class ContoDeposito extends Conto {

	public ContoDeposito(String Titolare, String Data) {
		super(Titolare, Data);
		super.limitePrelievo = 1000;
		interessi = new CalcoloInteressi(0.1, this);
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
