package entidades;

import java.math.BigDecimal;

public abstract class Investimento {
	private String nome;
	private BigDecimal valorAplicado;

	//Construtor:
	public Investimento(String nome, String valorAplicado) {
		this.nome = nome;
		this.valorAplicado = new BigDecimal(valorAplicado);
	}
	
	//getters e setters:
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorAplicado() {
		return valorAplicado;
	}

	public void setValorAplicado(String valorAplicado) {
		this.valorAplicado = new BigDecimal(valorAplicado);
	}

	//Demais métodos:
	
	//Adiciona valor aplicado no investimento
	public void aplicar(String valor) {
		this.valorAplicado = this.valorAplicado.add(new BigDecimal(valor));
	}
	
	//Deve mostrar os ganhos vindos do investimento
	public abstract BigDecimal ganhoTotal();
}
