package it.betacom.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class Conto {
	
	private LocalDate dataDiApertura;
	private String Titolare;
	private Double Saldo;
	protected Integer limitePrelievo = null;
	protected CalcoloInteressi interessi;
	protected double accInteressi = 0;

	public Conto(String Titolare, String Data) {
		this.Titolare = Titolare;

		try {
			this.dataDiApertura = LocalDate.parse(Data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.Saldo = (double) 1000;
	}

	public void versamento(int cifra, String data) {	
		//LocalDate Data = LocalDate.parse(data);
		setSaldo(getSaldo() + Math.abs(cifra));
		stampaSaldo();
		//this.interessi.generaInteressi(Data, 0);
	}

	
	public void prelievo(int cifra, String data) {
		//LocalDate Data = LocalDate.parse(data);
		if (limitePrelievo == null) {
			if (cifra > getSaldo()) {
				System.out.println(
						"Impossibile effettuare il prelievo. L'importo inserito supera il valore del saldo disponibile");
			} else {
				setSaldo(getSaldo() - Math.abs(cifra));
				System.out.println("Sono stati prelevati : " + Math.abs(cifra) + "$");
			}
		}else {
			
			if(cifra > limitePrelievo) {
				System.out.println("Imopssibile prelevare.\nLimite di prelievo : " + limitePrelievo);
			}else {
				if (cifra > getSaldo()) {
					System.out.println(
							"Impossibile effettuare il prelievo. L'importo inserito supera il valore del saldo disponibile");
				} else {
					setSaldo(getSaldo() - Math.abs(cifra));
					System.out.println("Sono stati prelevati : " + Math.abs(cifra) + "$");
				}
			}
			
		}
		//this.interessi.generaInteressi(Data, 0);
		stampaSaldo();
	}
//	public void operazioni(Scanner scanner) {
//
//		boolean valid;
//
//		String nuovaOp = "si";
//
//		while (nuovaOp.toLowerCase().equals("si")) {
//			System.out.println("Quale operazione desideri effettuare : (Prelievo p - Versamento v)  : ");
//			String operazione = scanner.nextLine();
//			valid = false;
//
//			while (!valid) {
//				if (operazione.toLowerCase().equals("p")) {
//					prelievo(scanner);
//					valid = true;
//				} else if (operazione.toLowerCase().equals("v")) {
//					versamento(scanner);
//					valid = true;
//				} else {
//					System.out.println("Operazione non valida. Riprova");
//					System.out.println("Quale operazione desideri effettuare : (Prelievo - Versamento)  : ");
//					operazione = scanner.nextLine();
//				}
//			}
//			scanner.nextLine();
//			System.out.println("Desideri effettuare una nuova operazione ? (si - no)");
//			nuovaOp = scanner.nextLine();
//		}
//		stampaSaldo();
//	}

	public void stampaSaldo() {
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Saldo corrente : " + df.format(getSaldo()) + "$");
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(Double saldo) {
		this.Saldo = saldo;
	}

	public LocalDate getDataDiApertura() {
		return dataDiApertura;
	}

	public String getTitolare() {
		return Titolare;
	}

	public void setTitolare(String titolare) {
		Titolare = titolare;
	}
	
	public void generaInteressi(String Data) {
		// TODO Auto-generated method stub
		LocalDate data = LocalDate.parse(Data);
		double tmp = getSaldo();
		this.interessi.generaInteressi(data, 1);
		this.accInteressi = getSaldo() - tmp;
		System.out.println("Interessi accumulati : " + accInteressi + " | Data : "+ data.toString());
		this.accInteressi = 0;
		
	}


}
