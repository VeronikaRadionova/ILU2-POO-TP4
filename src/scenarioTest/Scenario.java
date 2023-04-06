package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.IEtal;
import villagegaulois.IVillage;
import villagegauloisold.DepenseMarchand;
import villagegauloisold.Etal;

public class Scenario {

	public static void main(String[] args) {

		IVillage village = new IVillage() {
			int nbEtalsMax = 6;
			int nbEtals = 0;
			private IEtal[] marche = new IEtal[nbEtalsMax];
			

			@Override
			public <P extends Produit> boolean installerVendeur(villagegaulois.Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				if (nbEtals < nbEtalsMax) {
					etal.installerVendeur(vendeur, produit, prix);
					marche[nbEtals] = etal;
					nbEtals = nbEtals + 1;
					return true;
				}
				return false;
			}

			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				DepenseMarchand[] depenseMarchand = new DepenseMarchand[nbEtals];
				int i = 0;
				int nbEtalP = 0;
				int nbAchete = 0;
				double prixPaye = 0;
				int nbMarchand = 0; 
				while (quantiteSouhaitee > 0 && nbEtals > i) {
					nbEtalP = marche[i].contientProduit("sanglier", quantiteSouhaitee - nbAchete);
					if (nbEtalP > 0) {
						prixPaye = marche[i].acheterProduit(nbEtalP);
						Gaulois vendeur = marche[i].getVendeur();
						depenseMarchand[nbMarchand] = new DepenseMarchand(vendeur, nbEtalP, produit, prixPaye);
						nbMarchand = nbMarchand + 1;
					} // pochemu-to ne schitaet tcenu celikom kak u myasa, a prosto vydayot tu, chto propisana
					
					nbAchete = nbAchete + nbEtalP;
					i++;
				}
				
				return depenseMarchand;
			}
			
			@Override
			public String afficherVillage() {
				StringBuilder village = new StringBuilder();
				for (int i = 0; i < nbEtals; i++) {
					village.append(marche[i].etatEtal() + "\n");
				}
				return village.toString();
			}
		};
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village.afficherVillage());

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village.afficherVillage());
		
	}

}
