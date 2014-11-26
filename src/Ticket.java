import java.io.Serializable;

public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cliente;
	private String senha;
	private String caixaAtendente;
	private String preferencial;


	public Ticket(String cliente, String senha, String preferencial) {
		
		this.cliente = cliente;
		this.senha = senha;
		this.preferencial = preferencial;
	}
	
	//Construtor vazio da classe
	public Ticket() {

	}

	//Gerando os getters and setters
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPreferencial() {
		return preferencial;
	}

	public void setPreferencial(String preferencial) {
		this.preferencial = preferencial;
	}

	public String getCaixaAtendente() {
		return caixaAtendente;
	}

	public void setCaixaAtendente(String caixaAtendente) {
		this.caixaAtendente = caixaAtendente;
	}

	//Sobrescrevendo o método toString
	@Override
	public String toString() {
		String dadosTicket = "Senha: " + this.senha + "\n" + "Cliente: " + this.cliente + "\n" + "Prioridade: " + this.preferencial + "\n";

		return dadosTicket;
	}
}
