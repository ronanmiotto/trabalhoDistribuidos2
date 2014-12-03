import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class InterfaceCaixaImpl extends UnicastRemoteObject implements InterfaceCaixa {
	

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private ArrayList<Ticket> listaTickets;
	private InterfacePainel painel;
	private int numCaixa = 1;
	int senhaTicket = 0;

	// Construtor da classe
	public InterfaceCaixaImpl(InterfacePainel painel) throws RemoteException {
		
		this.listaTickets = new ArrayList<Ticket>();
		this.painel = painel;
		
	}

	//Gerando a senha
	public Ticket gerarTicket(Ticket ticket) throws RemoteException {
	
		this.senhaTicket +=1;

		ticket.setSenha(String.valueOf(senhaTicket));
		listaTickets.add(ticket);

		return ticket;
	}

	//Chamando os próximos tickets, de acordo com sua prioridade
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
	
	// Gerador do número do caixa
	public String numCaixaAtendente() {
		
		return "Caixa " + this.numCaixa++;
		
	}

	//Verificando se existem novos tickets para serem lidos
	public Boolean verificarNovosTickets() throws RemoteException {
		
		if(this.listaTickets.size() == 0){
			
			System.out.println("\n Não há mais Tickets\n");
			
			return false;
			
			
		} else {
			
			System.out.println("\nHá mais Tickets\n");
			
			return true;
		}
	}


}
