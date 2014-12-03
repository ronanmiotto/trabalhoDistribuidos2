import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class StartCaixa {
	
	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			InterfaceCaixa implCaixa = (InterfaceCaixa) registry.lookup("caixa");

			Scanner ler = new Scanner(System.in);
			
			Ticket ticket = new Ticket();
			
			System.out.println("___| Tickets a serem atendidos |___");
			
			System.out.println("\nChamar novos Tickets\n");
			
			while (ler.nextLine() != null) {
				
				while(!implCaixa.verificarNovosTickets()) {
					
				}
				
				ticket = implCaixa.ticketSeguinte(implCaixa.numCaixaAtendente());
				
				if(ticket != null){
					
					System.out.println("_____________________");
					
					System.out.println("### Ticket ###");
					System.out.println("Senha -> " + ticket.getSenha());
					System.out.println("Cliente -> " + ticket.getCliente());
					System.out.println("Atendimento Prioritário -> " + ticket.getPreferencial());
					
					System.out.println("_____________________");
					System.out.println("---------------------");
					
				} else {
					
					System.out.println("\nSem Tickets!\n");
				}
				
				System.out.println("\nAtender novos Tickets");
				System.out.println("\n**********************************\n\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
