import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfacePainelImpl extends UnicastRemoteObject implements InterfacePainel {
	
	private static final long serialVersionUID = 1L;
	
	// Construtor vazio da classe
	public InterfacePainelImpl() throws RemoteException {
		
	}
	
	//Método para atender ticket seguinte
	public Ticket ticketSeguinte(Ticket ticket) throws RemoteException {

		 System.out.println("Atendendo o pŕoximo cliente");
		
		 System.out.println("_____________________");
		 System.out.println("---------------------");
		
		 System.out.println("Cliente -> " + ticket.getCliente());
		 System.out.println("Senha -> " + ticket.getSenha());
		 System.out.println("Caixa Número -> " + ticket.getCaixaAtendente());
		
		 System.out.println("_____________________");
		 System.out.println("---------------------");
		//
		return null;

	}
}
