import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartServer {	
	
	// Main principal
	public static void main(String[] args) {
		
		try {
			
			Registry registryCaixa = LocateRegistry.createRegistry(1099);
			
			Registry registryPainel = LocateRegistry.getRegistry("127.0.0.1", 1098);
			InterfacePainel painel = (InterfacePainel) registryPainel.lookup("interfacePainel");
			
			registryCaixa.rebind("caixa", new InterfaceCaixaImpl(painel));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
