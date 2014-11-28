
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCaixa extends Remote {
	
	
	public String caixaAtendente() throws RemoteException;
	
	public Ticket gerarTicket(Ticket ticket) throws RemoteException;

	public Ticket ticketSeguinte(String ticket) throws RemoteException;
	
	public Boolean verificarNovosTickets() throws RemoteException;
	
	
}
