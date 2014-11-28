import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;

import javax.xml.bind.ParseConversionEvent;

public class InterfaceCaixaImpl extends UnicastRemoteObject implements InterfaceCaixa {
	

	private static final long serialVersionUID = 1L;
	// Atributos
	private ArrayList<Ticket> listaTickets;
	private InterfacePainel painel;
	private int senhaTicket =0;
	private int numCaixa = 0;


	// Construtor da classe
	public InterfaceCaixaImpl(InterfacePainel painel)
	
		throws RemoteException {
		this.listaTickets = new ArrayList<Ticket>();
		this.painel = painel;
	}

	// Métodos
	public String numCaixaAtendente() throws RemoteException {
		
		return "Caixa " + this.numCaixa++;
	}

	public Ticket gerarTicket(Ticket ticket) throws RemoteException {
	
		this.senhaTicket += 1;

		ticket.setSenha(String.valueOf(this.senhaTicket));
		listaTickets.add(ticket);

		return ticket;
	}

	public Ticket ticketSeguinte(String caixa) throws RemoteException {
		
		if (this.listaTickets.size() != 0) {
			
			for (int i = 0; i < this.listaTickets.size(); i++) {
				
				Ticket ticket = this.listaTickets.get(i);

				if (ticket.getPreferencial().equalsIgnoreCase("Sim")) {
					
					this.listaTickets.remove(i);

					ticket.setCaixaAtendente(String.valueOf(numCaixa));

					try {
						
						painel.ticketSeguinte(ticket);
						
					} catch (Exception e) {
						e.printStackTrace();
					}

					return ticket;
				}
			}

			Ticket ticket = this.listaTickets.get(0);
			this.listaTickets.remove(0);
			ticket.setCaixaAtendente(caixa);

			try {
				
				painel.ticketSeguinte(ticket);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			return ticket;
		}

		return null;
	}

	public Boolean verificarNovosTickets() throws RemoteException {
		
		if(this.listaTickets.size() == 0){
			
			return false;
			
		} else {
			
			return true;
		}
	}

	@Override
	public String caixaAtendente() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
