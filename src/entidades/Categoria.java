package entidades;

import java.math.BigDecimal;

public class Categoria {
	private String nome;
	private BigDecimal valor;
	
	//Construtor
	public Categoria(String nome, String valor) {
		super();
		this.nome = nome;
		this.valor = new BigDecimal(valor);
	}
	
	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = new BigDecimal(valor);
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", valor=" + valor + "]";
	}

}
