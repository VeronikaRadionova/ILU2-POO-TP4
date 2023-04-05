package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;

	
	public Sanglier(/*Unite unite,*/ int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	public String description() {
		return "sanglier de " + String.valueOf(poids) + " kg chassé par " + chasseur.getNom();
	}
}
