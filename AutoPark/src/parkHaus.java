
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class parkHaus {

	public static void main(String[] args) {
		
		long parkZeit=0; int knopf=0, schranke=0, parkKarte=0;
		double parkGeb�hr=0, minuten=0, geldEinwurf=0; int geldAuswahl=0;
		String kontrol="";
		LocalDateTime ausFahrt = LocalDateTime.now();
		
		DecimalFormat df = new DecimalFormat(",##0.00");
		
		//----------------------
		// Einfahrt zum Parkhaus
		//----------------------
		System.out.println("Bet�tigen Sie bitte eins (1)");
		knopf=new Scanner(System.in).nextInt();
		System.out.println("Eingabe DatumZeit:..(yyyy-MM-ddThh:mm:ss)");
		Scanner scan=new Scanner(System.in); 
		String dateTime=scan.next(); 
		LocalDateTime einFahrt=LocalDateTime.parse(dateTime);
		System.out.println("Ihre Parkkarte wird geschrieben.....");
		System.out.println("Eingangsdatum: " +einFahrt);
		System.out.println("Schranke ist �ffnett");
		
		//---------------
		// KassenAutomat
		//---------------
		System.out.println("Eingabe Parkkarte: ....Bet�tigen Sie bitte (1)");
		parkKarte = scan.nextInt(); 
		
		System.out.println("Parkarte wird gelesen...");
		System.out.println("Ausgangsdatum: " +ausFahrt);
		long hours = ChronoUnit.HOURS.between(einFahrt, ausFahrt);
        long minutes = ChronoUnit.MINUTES.between(einFahrt, ausFahrt);
        long second = ChronoUnit.SECONDS.between(einFahrt, ausFahrt);
        System.out.println("Ihr Auto steht im Parkhaus "+hours+" stunde "+minutes%60+" minuten "+second%60+" sekunde");
        System.out.println("Preislist:\n...bis 30 minuten 0.50 �\n...bis 1 stunde 1.00 �\n...bis 2 stunde 2.00 �\n...bis 3 Stunde 3.00 �\njeder 30 minuten 0.50 �\n...bis 24 Stunde 20 �");
		parkGeb�hr=minutes*0.5/30;
        
        do {
        	System.out.println("Bezahlen Sie bitte "+parkGeb�hr+" �");
			System.out.println("Geldeinwurf:\n1-50 Cent\n2-1.00 �\n3-2.00 �\n4-5.00 �\n5-10.00 �\n6-20.00 �");
			geldAuswahl= new Scanner(System.in).nextInt();
			
			switch(geldAuswahl) {
				case 1:
					geldEinwurf=geldEinwurf+0.5;
					break;
				case 2:
					geldEinwurf=geldEinwurf+1.0;
					break;
				case 3:
					geldEinwurf=geldEinwurf+2.0;
					break;
				case 4:
					geldEinwurf=geldEinwurf+5.0;
					break;
				case 5:
					geldEinwurf=geldEinwurf+10.0;
					break;
				case 6:
					geldEinwurf=geldEinwurf+20.0;
					break;
				default:
					System.out.println("Falsch eingabe!!!");
					break;
			}
			System.out.println("Bereits bezahlt "+ geldEinwurf+" �");
			
		}
		while(geldEinwurf<parkGeb�hr);
        kontrol="beglichen";
        System.out.println("Erhalten Sie "+df.format((geldEinwurf-parkGeb�hr))+" � zur�ck.");
        System.out.println(parkGeb�hr+" � Parkgeb�hr wurde beglichen");
        System.out.println("Erhalten Sie bitte Ihre Parkkarte");
		
        //---------------------
        //Ausfahrt von Parkhaus
        //---------------------
        System.out.println("Eingabe Parkkarte:");
        System.out.println("Eingabe Parkkarte: ....Bet�tigen Sie bitte (1)");
		parkKarte = scan.nextInt(); 
        if(kontrol.equals("beglichen")) {
        	schranke=1;
        	System.out.println("Schranke ist �ffnet....\nGute Fahrt");
        }
        else {
        	schranke=0;
        	System.out.println("Parkgeb�hr wurde nicht beglichen...\nBezahlen Sie bitte Parkgeb�hr im Kassenautomat");
        }
		 
		
	}

}
