
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacePainel extends Remote {
	public Ticket ticketSeguinte(Ticket ticket) throws RemoteException;
}
