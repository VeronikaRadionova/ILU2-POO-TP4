package scenarioTest;

import produit.Produit;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
		IEtal[] etals = new IEtal[3];
		Etal<Sanglier> etalSanglier = new Etal<>();
		// Etal<Poisson> etalPoisson = new Etal<>(); 
		etals[0] = etalSanglier;
		// etals[1] = etalPoisson;
	}
	
}
