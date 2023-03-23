package produit;

public class Poisson extends Produit{
	private int date;

	public Poisson(String nom, Unite unite, int date) {
		super("poisson", unite);
		this.date = date;
	}
	
	public String description() {
		return "poisson pêchée " +	date;
	}
}
