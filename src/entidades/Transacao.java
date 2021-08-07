package entidades;

import java.math.BigDecimal;
import java.text.ParseException;

public class Transacao {
	private String destinatario;
	private Data data;
	private BigDecimal valor;
	
	//Construtor
	public Transacao(String destinatario, String data, String valor) throws ParseException {
		super();
		this.destinatario = destinatario;
		this.data = new Data(data);
		this.valor = new BigDecimal (valor);
	}
	
	//getters e setters
	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getData() {
		return data.getDataFormatada();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Transacao [destinatario=" + destinatario + ", data=" + data + ", valor=" + valor + "]";
	}
}
