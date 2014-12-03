import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class StartGeradorSenha {
	
	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			InterfaceCaixa implCaixa = (InterfaceCaixa) registry.lookup("caixa");

			Scanner ler = new Scanner(System.in);

			while (true) {	
				
				System.out.println("********************************");
				System.out.println("Seja Bem Vindo ao Banco do Povo");
				System.out.println("********************************");
				System.out.println("\nNOVO ATENDIMENTO");
				System.out.println("\n->Por favor, retire sua senha<-\n");
				
				Ticket ticket = new Ticket();
				
				System.out.print("Nome -> ");
				ticket.setCliente(ler.nextLine());

				System.out.print("\nAtendimento Prioritário -> ");
				ticket.setPreferencial(ler.nextLine());
				ticket = implCaixa.gerarTicket(ticket);
				
				System.out.println("_____________________");
				System.out.print("Senhor(a) " + ticket.getCliente() + "\nSenha -> " + ticket.getSenha() + "\n");
				System.out.println("_____________________\n");
				System.out.println("----------#----------#----------#----------#----------#----------#----------#----------#----------#----------#");
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
