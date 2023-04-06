package scenarioTest;

import villagegaulois.Etal;

import personnages.Gaulois;
import produit.*;


public class ScenarioTest {
	public static void main(String[] args) {
		// IEtal[] etals = new IEtal[3];
		// Etal<Sanglier> etalSanglier = new Etal<>();
		// Etal<Poisson> etalPoisson = new Etal<>(); 
		// etals[0] = etalSanglier;
		// etals[1] = etalPoisson;
		
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		//IEtal[] etals = new IEtal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		
		etalSanglier1.installerVendeur(asterix, sangliersAsterix, 10);
		etalSanglier2.installerVendeur(obelix, sangliersObelix, 7);;
		etalPoisson.installerVendeur(ordralfabetix, poissons, 8);;
		
		Etal[] marche = {etalSanglier1, etalSanglier2, etalPoisson};
		
		
		
		
		int nbSVendu = 0;
		int nbSCherche = 3;
		int nbSEtal = 0;
		int i = 0; 
		double prixAPaye;
		
		System.out.println("ETAT MARCHE");
		for (int j = 0; j < marche.length; j++) {
			System.out.println(marche[j].etatEtal());
		}
		
		while((nbSCherche > nbSVendu) && (i < marche.length)) {
			
			nbSEtal = marche[i].contientProduit("sanglier", nbSCherche - nbSVendu);
			if (nbSEtal > 0) {
				prixAPaye = marche[i].acheterProduit(nbSEtal);
				System.out.println("A l'etal " + i + " je paye " + prixAPaye + " sous.");
			} // pochemu-to ne schitaet tcenu celikom kak u myasa, a prosto vydayot tu, chto propisana
			
			nbSVendu = nbSVendu + nbSEtal;
			// System.out.println(nbSVendu);
			i++;
		}
		
		System.out.println("Je voulais " + nbSCherche + " sangliers, j'en ai achete " + nbSVendu + "\n");
		
		System.out.println("ETAT MARCHE");
		for (int j = 0; j < marche.length; j++) {
			System.out.println(marche[j].etatEtal());
		}
	}
}
