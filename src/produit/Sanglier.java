package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;

	
	public Sanglier(String nom, Unite unite, int poids, Gaulois chasseur) {
		super("sanglier", unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	public String description() {
		return "sanglier de " + String.valueOf(poids) + " kg chassé par " + chasseur.getNom();
	}
}
