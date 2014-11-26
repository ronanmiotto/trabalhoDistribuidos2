import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class StartCaixa {
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			InterfaceCaixa implCaixa = (InterfaceCaixa) registry.lookup("caixa");

			Scanner ler = new Scanner(System.in);
			
			System.out.println("___| Tickets a serem atendidos |___");
			
			while (ler.nextLine() != null) {
				
				
				while(!implCaixa.verificarNovosTickets()) { }
				
				Ticket ticket = implCaixa.ticketSeguinte(implCaixa.getCaixaAtendente());
				
				if(ticket != null){
					
					System.out.println("Chamando Clientes para o Atendimento");
					
					System.out.println("---------------------");
					System.out.println("_____________________");
					
					System.out.println("### Ticket ###");
					System.out.println("Senha Número -> " + ticket.getSenha());
					System.out.println("Cliente -> " + ticket.getCliente());
					System.out.println("Preferencial -> " + ticket.getPreferencial());
					
					System.out.println("_____________________");
					System.out.println("---------------------");
					
				} else {
					
					System.out.println("____________________");
					System.out.println("Não Há Tickets!");
					System.out.println("____________________");
				}
				
				System.out.println("\nAtender novos Tickets");
				System.out.println("\n************************************************************\n\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
