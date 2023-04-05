package produit;

public class Poisson extends Produit{
	private String date;

	public Poisson(String date) {
		super("poisson", Unite.PIECE);
		this.date = date;
	}
	
	public String description() {
		return "poisson pêchée " +	date;
	}
}
