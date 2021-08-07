package entidades;

import java.math.BigDecimal;

public class CartaoDeCredito {
	private String nomeDoBanco;
	private String nomeDoTitular;
	private String numDoCartao;
	private BigDecimal limiteDoCartao;
	private BigDecimal valorDaFatura;

	// Construtor
	public CartaoDeCredito(String nomeDoBanco, String nomeDoTitular, String numDoCartao, String limiteDoCartao,
			String valorDaFatura) {
		super();
		this.nomeDoBanco = nomeDoBanco;
		this.nomeDoTitular = nomeDoTitular;
		this.numDoCartao = numDoCartao;
		this.limiteDoCartao = new BigDecimal(limiteDoCartao);
		this.valorDaFatura = new BigDecimal(valorDaFatura);
	}

	// getter e setters
	public String getNomeDoBanco() {
		return nomeDoBanco;
	}

	public void setNomeDoBanco(String nomeDoBanco) {
		this.nomeDoBanco = nomeDoBanco;
	}

	public String getNomeDoTitular() {
		return nomeDoTitular;
	}

	public void setNomeDoTitular(String nomeDoTitular) {
		this.nomeDoTitular = nomeDoTitular;
	}

	public String getNumDoCartao() {
		return numDoCartao;
	}

	public void setNumDoCartao(String numDoCartao) {
		this.numDoCartao = numDoCartao;
	}

	public BigDecimal getLimiteDoCartao() {
		return limiteDoCartao;
	}

	public void setLimiteDoCartao(String limiteDoCartao) {
		this.limiteDoCartao = new BigDecimal(limiteDoCartao);
	}

	public BigDecimal getValorDaFatura() {
		return valorDaFatura;
	}

	public void setValorDaFatura(String valorDaFatura) {
		this.valorDaFatura = new BigDecimal(valorDaFatura);
	}

	@Override
	public String toString() {
		return "CartaoDeCredito [nomeDoBanco=" + nomeDoBanco + ", nomeDoTitular=" + nomeDoTitular + ", numDoCartao="
				+ numDoCartao + ", limiteDoCartao=" + limiteDoCartao + ", valorDaFatura=" + valorDaFatura + "]";
	}
}
