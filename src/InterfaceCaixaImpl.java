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


	// Construtor da classe
	public InterfaceCaixaImpl(InterfacePainel painel)
	
		throws RemoteException {
		this.listaTickets = new ArrayList<Ticket>();
		this.painel = painel;
	}

	//Gerando as senhas
	public Ticket gerarTicket(Ticket ticket) throws RemoteException {
	
		this.senhaTicket += 1;

		ticket.setSenha(String.valueOf(this.senhaTicket));
		listaTickets.add(ticket);

		return ticket;
	}

	//Método responsável pelo tratamento dos tickets
	public Ticket ticketSeguinte(String caixa) throws RemoteException {
		
		if (this.listaTickets.size() != 0) {
			
			for (int i = 0; i < this.listaTickets.size(); i++) {
				
				Ticket ticket = this.listaTickets.get(i);

				if (ticket.getPreferencial().equalsIgnoreCase("Sim")) {
					
					this.listaTickets.remove(i);

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

			try {
				
				painel.ticketSeguinte(ticket);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			return ticket;
		}

		return null;
	} 
	
	//Verificando se existem novos tickets na lista
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
