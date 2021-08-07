package entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
	private Date data;
	private static final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy");
	
	public Data(String data) throws ParseException {
		this.data = FORMATO.parse(data);
	}
	
	public String getDataFormatada(){
		return FORMATO.format(data);
	}
}
