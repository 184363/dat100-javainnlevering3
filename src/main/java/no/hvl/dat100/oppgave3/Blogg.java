package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;
	
	public Blogg() {

		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {

		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {

		return nesteledig;
	}
	
	public Innlegg[] getSamling() {

		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;

	}

	public boolean finnes(Innlegg innlegg) {

		return finnInnlegg(innlegg) != -1;
	
	}

	public boolean ledigPlass() {

		return nesteledig < innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		
		String resultat = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			resultat += innleggtabell[i].toString();
		}
		return resultat;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] nyTabell = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nesteledig; i++) {
			nyTabell[i] = innleggtabell[i];
		}
		innleggtabell = nyTabell;
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (!finnes(innlegg)) {
			if (!ledigPlass()) {
				utvid();
			}
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int index = finnInnlegg(innlegg);
		if (index != -1) {
			innleggtabell[index] = innleggtabell[nesteledig - 1];
			innleggtabell[nesteledig -1] = null;
			nesteledig--;
			return true;
		}
		return false;
	}
	
//	//public int[] search(String keyword) {
//		
//		//int[] ids = new int[nesteledig];
//		int count = 0;
//		
//		for (int i = 0; i < nesteledig; i++) {
//			if (innleggtabell[i].getTekst().contains(keyword)) {
//				ids[count++] = innleggtabell[i].getId();
//			}
//		}
//		
//		int[] resultat = new int[count];
//		System.arraycopy(ids, 0, resultat, 0, count);
//		return resultat;	
//	}
}