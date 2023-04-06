package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;

	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	public int getPoids() {
		return poids;
	}

	public Gaulois getChasseur() {
		return chasseur;
	}

	@Override
	public String description() {
		return "sanglier de " + String.valueOf(poids) + " kg chassé par " + chasseur.getNom();
	}
	
	@Override
	public double calculerPrix(int prix) {
		return prix * (poids/1000);
	}
}
