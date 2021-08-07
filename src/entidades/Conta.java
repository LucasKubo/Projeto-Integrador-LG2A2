package entidades;

public class Conta {
	private Usuario donoDaConta;
	private String nomeDoBanco;
	private Moeda saldo;
	private Receita receita;
	private Despesa despesa;
	
	//Construtor:
	public Conta(Usuario donoDaConta, String nomeDoBanco, String saldo, Receita receita, Despesa despesa) {
		super();
		this.donoDaConta = donoDaConta;
		this.nomeDoBanco = nomeDoBanco;
		this.saldo = new Moeda(saldo);
		this.receita = receita;
		this.despesa = despesa;
	}
	
	//getters e setters:
	public Usuario getDonoDaConta() {
		return donoDaConta;
	}

	public void setDonoDaConta(Usuario donoDaConta) {
		this.donoDaConta = donoDaConta;
	}
	
	public String getNomeDoBanco() {
		return nomeDoBanco;
	}

	public void setNomeDoBanco(String nomeDoBanco) {
		this.nomeDoBanco = nomeDoBanco;
	}

	public String getSaldo() {
		return saldo.getValorFormatado();
	}
	
	public Receita getReceita() {
		return receita;
	}
	
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
	
	//Outros métodos:
	//Adiciona valor ao saldo da conta
	public void depositar(String valor) {
		saldo.acrescentarValor(valor);
	}
	
	public void exibeConta() {
		System.out.println("[Dono da conta => " + donoDaConta.getNomeDoUsuario() + "],"
							+ "[Banco => " + getNomeDoBanco() + "],"
							+ "[saldo => " + getSaldo() + "]");		
	}
	
	@Override
	public String toString() {
		return "Conta [donoDaConta=" + donoDaConta + ", nomeDoBanco=" + nomeDoBanco + ", receita="
				+ receita + ", despesa=" + despesa + "]";
	}
	
}
