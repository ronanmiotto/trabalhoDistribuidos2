import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartPainel {

	public static void main(String[] args) {
		
		try {
			
			Registry registry = LocateRegistry.createRegistry(1098);
			registry.rebind("interfacePainel", new InterfacePainelImpl());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
