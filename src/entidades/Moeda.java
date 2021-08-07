package entidades;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Moeda {
	private BigDecimal valor;
	private static final String VALOR_UNITARIO = "R$";
	private static final DecimalFormat FORMATO = new DecimalFormat(VALOR_UNITARIO + "#,###,##0.00");
	
	public Moeda(String valor){
		this.valor = new BigDecimal(valor);
	}
	
	public void acrescentarValor (String valor) {
		this.valor = this.valor.add(new BigDecimal(valor));
	}
	
	public String getValorFormatado() {
		return FORMATO.format(valor);
	}
	
}
