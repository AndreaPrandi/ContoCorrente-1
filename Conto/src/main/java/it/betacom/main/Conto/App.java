package it.betacom.main.Conto;

import java.time.LocalDate;
import java.util.Scanner;

import it.betacom.model.ContoCorrente;
import it.betacom.model.ContoDeposito;
import it.betacom.model.ContoInvestimento;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		
		System.out.println("Conto corrente : ");
		ContoCorrente contoCorrente = new ContoCorrente("giuseppe",  "2020-12-31");
		contoCorrente.stampaSaldo();
		contoCorrente.generaInteressi("2021-12-31");
		contoCorrente.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoCorrente.generaInteressi("2022-12-31");
		contoCorrente.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoCorrente.prelievo(900, "2023-03-31");
		contoCorrente.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");
		contoCorrente.generaInteressi(LocalDate.now().toString());
		contoCorrente.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		System.out.println("-----------------------------------------------------------------");
		System.out.println("Conto Deposito : ");

		ContoDeposito contoDeposito = new ContoDeposito("giuseppe",  "2020-12-31");
		contoDeposito.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoDeposito.generaInteressi("2021-12-31");
		contoDeposito.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoDeposito.generaInteressi("2022-12-31");
		contoDeposito.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoDeposito.prelievo(900, "2023-03-15");
		contoDeposito.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoDeposito.generaInteressi(LocalDate.now().toString());
		contoDeposito.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");


		System.out.println("-----------------------------------------------------------------");
		System.out.println("Conto Investimento : ");

		ContoInvestimento contoInvestimento = new ContoInvestimento("giuseppe", "2020-12-31");
		contoInvestimento.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoInvestimento.generaInteressi("2021-12-31", 1);
		contoInvestimento.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");
		
		contoInvestimento.generaInteressi("2022-12-31", 1);
		contoInvestimento.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoInvestimento.versamento(900, "2023-03-15");
		contoInvestimento.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");

		contoInvestimento.generaInteressi(LocalDate.now().toString(), 1);
		contoInvestimento.stampaSaldo();
		System.out.println("-----------------------------------------------------------------");


	}
}
