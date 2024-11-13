package no.hvl.dat100.oppgave4;

import java.io.BufferedWriter;
import no.hvl.dat100.oppgave3.*;
import java.io.FileWriter;
import java.io.IOException;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		String filbane = mappe + "/" + filnavn;
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filbane))){
			writer.write(samling.toString());
			return true;
		}catch (IOException e) {
			System.err.println("Feil ved skriving til fil: " + e.getMessage());
			return false;
		}
	
	}
}
