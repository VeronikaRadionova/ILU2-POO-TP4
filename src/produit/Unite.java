package produit;

public enum Unite {
	LITTRE (""), GRAMME (""), KILOGRAMME (""), CENTILITRE (""), MILILITTRE (""), PIECE ("");
	
	private String nom;
	
	private Unite(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	}
}

//naiti kak my delaem enumy chtoby oni vyvodilis i vyzyvalis 