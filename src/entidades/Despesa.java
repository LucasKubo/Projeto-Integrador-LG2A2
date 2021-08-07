package entidades;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Despesa {
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Transacao> transacoes = new ArrayList<Transacao>();
	private List<CartaoDeCredito> cartoesDeCredito = new ArrayList<CartaoDeCredito>();
	
	//Construtores
	public Despesa() {};
	
	public Despesa(List<Categoria> categorias, List<Transacao> transacoes, List<CartaoDeCredito> cartoesDeCredito,
			Date mesDaDespesa) {
		this.categorias = categorias;
		this.transacoes = transacoes;
		this.cartoesDeCredito = cartoesDeCredito;
	}
	
	//getters e setters
	public List<CartaoDeCredito> getCartoesDeCredito() {
		return cartoesDeCredito;
	}

	//Demais métodos
	
	//Adiciona um objeto de Categoria na lista categorias
	public void addCategoria(String nome, String valor) {
		categorias.add(new Categoria(nome, valor));
	}
	
	public void removeCategoria(String nome) {
		for (int i=0; i<categorias.size(); i++) {
			if(categorias.get(i).getNome().equals(nome)) {
				categorias.remove(i);
			}
		}
	}
	
	//Adiciona um objeto de Transacao na lista transacoes
	public void addTransacao(String destinatario, String data, String valor) throws ParseException {
		transacoes.add(new Transacao(destinatario,data,valor));
	}
	
	//Adiciona um objeto de CartaoDeCredito na lista cartoesDeCredito
	public void addCartao(String nomeDoBanco, String nomeDoTitular, String numDoCartao, String limiteDoCartao, String valorDaFatura) {
		cartoesDeCredito.add(new CartaoDeCredito(nomeDoBanco, nomeDoTitular, numDoCartao, limiteDoCartao, valorDaFatura));
	}
	
	
	//Retorna o valor total de todas as despesas
	public BigDecimal valorTotal(){
		
		BigDecimal totalFinal = new BigDecimal("0.0");
		
		BigDecimal totalCategorias = new BigDecimal("0.0"); //Percorrendo e pegando todos os valores das categorias
		for (int i=0; i<categorias.size(); i++) {
			totalCategorias = totalCategorias.add(categorias.get(i).getValor());
		}
		
		BigDecimal totalTransacoes = new BigDecimal("0.0");
		for (int i=0; i<transacoes.size(); i++) {  //Percorrendo e pegando todos os valores das transacoes
			totalTransacoes = totalTransacoes.add(transacoes.get(i).getValor());
		}
		
		BigDecimal totalFaturas = new BigDecimal("0.0");
		for (int i=0; i<cartoesDeCredito.size(); i++) {  //Percorrendo e pegando todos os valores das faturas
			totalFaturas = totalFaturas.add(cartoesDeCredito.get(i).getValorDaFatura());
		}
		
		totalFinal = totalCategorias.add(totalTransacoes.add(totalFaturas));
		
		return totalFinal;
	}
	
	//Exibe uma lista formatada com as todas classificações de despesas e seus respectivos valores
	public void listarDespesas() {
		System.out.println("Despesas");
		for (int i=0; i<categorias.size(); i++) {
			System.out.println(categorias.get(i).getNome() + ": "
								+ " [Valor => "  + "R$ " + categorias.get(i).getValor() + "]");
		}
		for (int i=0; i<transacoes.size(); i++) {
			System.out.println("Transferência: [Destinatário => " + transacoes.get(i).getDestinatario() + "],"
								+"[Data => " + transacoes.get(i).getData() + "],"
								+ "[Valor => " + "R$ "+ transacoes.get(i).getValor() + "]");
		}
		for (int i=0; i<cartoesDeCredito.size(); i++) {
			System.out.println("Fatura: [banco do cartão => " + cartoesDeCredito.get(i).getNomeDoBanco() + "],"
								+"[numero do cartão => " + cartoesDeCredito.get(i).getNumDoCartao() + "],"
								+ "[valor => " + "R$ "+ cartoesDeCredito.get(i).getValorDaFatura() + "]");
		}
		System.out.println("TOTAL: R$ " + this.valorTotal());
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Despesa [categorias=" + categorias + ", transacoes=" + transacoes + 
				", cartaoDeCredito=" + cartoesDeCredito + "]";
	}
	
}
