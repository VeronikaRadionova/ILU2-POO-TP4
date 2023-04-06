package villagegaulois;

import personnages.Gaulois;
import produit.Produit;
import villagegaulois.Etal;
import villagegauloisold.DepenseMarchand;

public interface IVillage /*<P extends Produit>*/{
	
	public <P extends Produit> boolean installerVendeur(Etal<P> etal,
			Gaulois vendeur, P[] produit, int prix);
	
	public DepenseMarchand[] acheterProduit(String produit,
			int quantiteSouhaitee);
	
	public String afficherVillage();
}
