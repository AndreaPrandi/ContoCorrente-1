package it.betacom.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcoloInteressi {

	private double tassoInteressi;
	private LocalDate dataGenerazioneInteressi = null;
	private Conto conto;

	public CalcoloInteressi(double tassoInteressi, Conto conto) {
		// TODO Auto-generated constructor stub
		this.tassoInteressi = tassoInteressi / 365;
		this.conto = conto;
		dataGenerazioneInteressi = conto.getDataDiApertura();
	}

	public CalcoloInteressi(Conto conto) {
		// TODO Auto-generated constructor stub
		this.conto = conto;
		dataGenerazioneInteressi = conto.getDataDiApertura();
	}

	public void generaInteressi(LocalDate data, int diretto) {
		
		if (data.compareTo(dataGenerazioneInteressi) > 0) {
			if (diretto == 1) {
				conto.setSaldo(conto.getSaldo()
						+ (conto.getSaldo()
								* (tassoInteressi * ChronoUnit.DAYS.between(dataGenerazioneInteressi, data)))
						+ conto.accInteressi);
				conto.accInteressi = 0;
				dataGenerazioneInteressi = data;
			} else {
				conto.accInteressi += (conto.getSaldo()
						* (tassoInteressi * ChronoUnit.DAYS.between(dataGenerazioneInteressi, data)));
				dataGenerazioneInteressi = data;
			}
		} else {
			System.out.println("Impossibile generare interessi. Errore Date");
		}

		System.out.println("Interessi accumulati : " + conto.accInteressi);

	}

	public void generaInteressi(double tassoInteressi, LocalDate data, int diretto) {

		if (data.compareTo(dataGenerazioneInteressi) > 0) {
			if (diretto == 1) {
				conto.setSaldo(conto.getSaldo()
						+ (conto.getSaldo()
								* ((tassoInteressi / 365) * ChronoUnit.DAYS.between(dataGenerazioneInteressi, data)))
						+ conto.accInteressi);
				conto.accInteressi = 0;
				dataGenerazioneInteressi = data;
			} else {
				conto.accInteressi += (conto.getSaldo()
						* ((tassoInteressi / 365) * ChronoUnit.DAYS.between(dataGenerazioneInteressi, data)));
				dataGenerazioneInteressi = data;


			}
		} else {
			System.out.println("Impossibile generare interessi. Errore Date");
		}
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Tasso di interesse : " + df.format((tassoInteressi) * 100) + "%");
		if(conto.accInteressi > 0)
			System.out.println("Interessi accumulati : " + conto.accInteressi);

	}
}
