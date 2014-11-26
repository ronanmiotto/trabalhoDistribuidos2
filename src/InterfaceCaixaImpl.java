import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class InterfaceCaixaImpl extends UnicastRemoteObject implements InterfaceCaixa {
	

	private static final long serialVersionUID = 1L;
	// Atributos
	private ArrayList<Ticket> listaTickets;
	private InterfacePainel painel;
	private int numAtendenteCaixa = 1;
	int senha = 1;

	// Construtor da classe
	public InterfaceCaixaImpl(InterfacePainel painel)
	
		throws RemoteException {
		this.listaTickets = new ArrayList<Ticket>();
		this.painel = painel;
	}

	// Métodos
	public String getAtendente() {
		return "Caixa " + this.numAtendenteCaixa + 1;
	}

	public Ticket gerarTicket(Ticket ticket) throws RemoteException {
	
		
		if (listaTickets.size() == 0) {
			
			
		} else {
			
			Ticket tic = listaTickets.get(listaTickets.size() - 1);
			senha = Integer.parseInt(tic.getSenha()) + 1;
		}

		ticket.setSenha(String.valueOf(senha));
		listaTickets.add(ticket);

		return ticket;
	}

	public Ticket ticketSeguinte(String caixa) throws RemoteException {
		
		if (this.listaTickets.size() != 0) {
			
			for (int i = 0; i < this.listaTickets.size(); i++) {
				
				Ticket ticket = this.listaTickets.get(i);

				if (ticket.getPreferencial().equalsIgnoreCase("Sim")) {
					
					this.listaTickets.remove(i);

					ticket.setCaixaAtendente(caixa);

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

	//Sobrescrevendo o método caixaAtendente
	@Override
	public String getCaixaAtendente() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
