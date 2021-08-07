package entidades;

import java.math.BigDecimal;

public class RendaFixa extends Investimento{
	private int juros;
	
	//construtor:
	public RendaFixa(String nome, String valorAplicado, int juros) {
		super(nome, valorAplicado);
		this.juros = juros;
	}
	
	//getters e setters:
	public int getJuros() {
		return juros;
	}

	public void setJuros(int juros) {
		this.juros = juros;
	}
	
	//Outros métodos:
	
	//Retorna a receita gerada pelo investimento
	@Override
	public BigDecimal ganhoTotal() {
		int jurosConvertido = juros/100 + 1;
		return getValorAplicado().multiply(new BigDecimal(jurosConvertido));
	}
	
}
