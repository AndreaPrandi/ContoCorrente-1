package it.betacom.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Controlli {
	
	public Date controlloData(Scanner scanner) {
	     
		String dataUtente;
	    Boolean valida = false;
	    
	    String formato = "dd/MM/yyyy";
	      
	    SimpleDateFormat dataFormat = new SimpleDateFormat(formato);
	      
	    Date dataDiNascita = null;
	          
	    System.out.print("Inserisci la tua data di nascita (gg/mm/aaaa): "); 
	      
	    do {   
	          dataUtente = scanner.nextLine();  
	              
	          try {
	              dataDiNascita = dataFormat.parse(dataUtente);
	              valida = true;  
	          }  
	          catch (ParseException e) {   
	              System.out.print("Formato non valido. Riprova (gg/mm/aaaa): ");   
	          }         
	    } while(!valida); 
	      
	    return dataDiNascita;
	 }  
	
	public String controlloNome(Scanner scanner) {
		
		String nome = "";
		
		while(nome == "") {
			System.out.println("Inserisci nome : ");
			nome = scanner.nextLine();
			nome = nome.trim();
		}
		
		return nome;
	}
	
	public int controlloCifra(Scanner scanner) {
		int cifra = 0;
		boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                cifra = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Input non valido. Riprova.");
                scanner.next();
            }
        }
        
        return cifra;
	}
	
	
}