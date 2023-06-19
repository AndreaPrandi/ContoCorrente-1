package it.betacom.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

public class ContoInvestimento extends Conto {

	private double tassoInteresse;
	CalcoloInteressi interessi;

	public ContoInvestimento(String Titolare, String Data) {
		super(Titolare, Data);
		interessi = new CalcoloInteressi(this);	
		// TODO Auto-generated constructor stub
	}
	
	public void prelievo(int cifra, String data) {
		super.prelievo(cifra, data);
		generaInteressi(data, 0);
	}
	
	public void versamento(int cifra, String data) {
		super.versamento(cifra, data);
		this.generaInteressi(data, 0);
	}
	

	public void generaInteressi(String Data, int diretto) {
		LocalDate data = LocalDate.parse(Data);
		double tmp = getSaldo();
		tassoInteresse = Math.random() * 2 - 1;
		
		interessi.generaInteressi(tassoInteresse, data, diretto);
		this.accInteressi = getSaldo() - tmp;
		System.out.println("Interessi accumulati : " + accInteressi + " | Data : "+ data.toString());
		this.accInteressi = 0;
	}

}
