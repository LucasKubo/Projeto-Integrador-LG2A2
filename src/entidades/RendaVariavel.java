package entidades;

import java.math.BigDecimal;

public class RendaVariavel extends Investimento{
	private int dividendo;
	
	//Construtor:
	public RendaVariavel(String nome, String valorAplicado, int dividendo) {
		super(nome, valorAplicado);
		this.dividendo = dividendo;
	}
	
	//getters e setters:
	public int getDividendo() {
		return dividendo;
	}

	public void setDividendo(int dividendo) {
		this.dividendo = dividendo;
	}
	
	//Retorna a receita gerada pelo investimento
	@Override
	public BigDecimal ganhoTotal() {
		int dividendoConvertido = dividendo/100 + 1;
		return getValorAplicado().multiply(new BigDecimal(dividendoConvertido));
	}
}
