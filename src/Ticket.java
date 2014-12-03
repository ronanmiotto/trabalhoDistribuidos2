import java.io.Serializable;

public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cliente;
	private String senha;
	private String caixaAtendente;
	private String preferencial;
	
	//Construtor vazio da classe
	public Ticket() {

	}

	public Ticket(String cliente, String senha, String preferencial) {
		
		this.cliente = cliente;
		this.senha = senha;
		this.preferencial = preferencial;
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

}
