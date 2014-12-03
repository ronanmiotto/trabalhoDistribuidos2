
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfacePainelImpl extends UnicastRemoteObject implements InterfacePainel {

	private static final long serialVersionUID = 1L;
	
	// Construtor vazio da classe
	public InterfacePainelImpl() throws RemoteException {
		
		
	}
	
	public void mensagemPainel(){
		
		System.out.println("=========== PAINEL DE ATENDIMENTO ===========\n");
		
	}
		
	//  Chamando tickets no painel
	public Ticket ticketSeguinte(Ticket ticket) throws RemoteException {
		
		
		
		System.out.println("\n---> PRÓXIMO CLIENTE <---");
		
		System.out.println("_____________________");
		System.out.println("---------------------");
		
		System.out.println("Senhor(a) " + ticket.getCliente() + ".");
		System.out.println("Comparecer ao Caixa -> " + ticket.getCaixaAtendente());
		System.out.println("Senha -> " + ticket.getSenha());
		System.out.println("Atendimento Prioritário -> " + ticket.getPreferencial());
		
		
		System.out.println("_____________________");
		System.out.println("---------------------");
		
		return null;
	}
}
