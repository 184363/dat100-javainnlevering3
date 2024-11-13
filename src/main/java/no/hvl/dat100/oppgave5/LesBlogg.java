package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		Blogg blogg = new Blogg();
		String filbane = mappe + "/" + filnavn;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filbane))) {
			String linje = reader.readLine();
			int antallInnlegg = Integer.parseInt(linje);
			
			for (int i = 0; i < antallInnlegg; i++) {
				String type = reader.readLine();
				Innlegg innlegg;
				
				if (TEKST.equals(type)) {
                    
					int id = Integer.parseInt(reader.readLine());
                    String bruker = reader.readLine();
                    String dato = reader.readLine();
                    int likes = Integer.parseInt(reader.readLine());
                    String tekst = reader.readLine();

                    innlegg = new Tekst(id, bruker, dato, likes, tekst); 
                } else if (BILDE.equals(type)) {
                    
                    int id = Integer.parseInt(reader.readLine());
                    String bruker = reader.readLine();
                    String dato = reader.readLine();
                    int likes = Integer.parseInt(reader.readLine());
                    String tekst = reader.readLine();
                    String url = reader.readLine();

                    innlegg = new Bilde(id, bruker, dato, likes, tekst, url); 
                } else {
                    throw new IOException("Ugyldig innleggstype: " + type); 
                }

                blogg.leggTil(innlegg); 
            }

        } catch (IOException e) {
            System.err.println("Feil ved lesing av fil: " + e.getMessage());
            return null; 
        }

        return blogg;
			}
}
