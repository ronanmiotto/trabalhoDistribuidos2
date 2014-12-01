import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class StartGeradorSenha {
	
	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			InterfaceCaixa implCaixa = (InterfaceCaixa) registry.lookup("caixa");

			Scanner ler = new Scanner(System.in);
			
			//Entrada de dados para criação dos tickets
			while (true) {	
				
				System.out.println("********************************");
				System.out.println("Seja Bem Vindo ao Banco do Povo");
				System.out.println("********************************");
				System.out.println("\n->Por favor, retire sua senha<-\n");
				
				Ticket ticket = new Ticket();
				
				System.out.print("Nome -> ");
				ticket.setCliente(ler.nextLine());

				System.out.println("Preferencial -> ");
				ticket.setPreferencial(ler.nextLine());
				System.out.println("Caixa Número -> ");
				ticket.setCaixaAtendente(ler.nextLine());
				ticket = implCaixa.gerarTicket(ticket);
				
				System.out.println("_____________________");
				System.out.print("Senhor(a), " + ticket.getCliente() + ",\nSua senha é -> " + ticket.getSenha() + "\n");
				System.out.println("_____________________\n");
				System.out.println("----------#----------#----------#----------#----------#----------#----------#----------#----------#----------#\n");
				
				
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
