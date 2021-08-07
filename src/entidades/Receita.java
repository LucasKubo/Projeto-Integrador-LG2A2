package entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receita {
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Investimento> investimentos = new ArrayList<Investimento>();
	
	//construtor
	public Receita() {};
	
	public Receita(List<Categoria> categorias, List<Investimento> investimentos) {
		super();
		this.categorias = categorias;
		this.investimentos = investimentos;
	}
	
	//getters e setters
	
	//outros métodos
	
	//Retorna o valorTotal da receita
	public BigDecimal valorTotal() {
		BigDecimal valorFinal = new BigDecimal("0");
		
		BigDecimal valorCategorias = new BigDecimal("0"); //Percorrendo e pegando valores dos itens da lista de categorias
		for(int i=0;i<categorias.size();i++) {
			valorCategorias = valorCategorias.add(categorias.get(i).getValor());
		}
		
		BigDecimal valorInvestimentos = new BigDecimal("0"); //Percorrendo e pegando valores dos itens da lista de investimentos
		for(int i=0;i<investimentos.size();i++) {
			valorInvestimentos = valorInvestimentos.add(investimentos.get(i).ganhoTotal());
		}

		valorFinal = valorCategorias.add(valorInvestimentos);
		return valorFinal;
	}
	
	//Adiciona um objeto da classe Categoria na lista de categorias
	public void addCategoria(String nome, String valor) {
		categorias.add(new Categoria (nome,valor));
	}
	
	//Remove um objeto da classe Categoria na lista de categorias buscado pelo nome
	public void removeCategoria(String nome) {
		for(int i=0;i<categorias.size();i++) {
			if(categorias.get(i).getNome().equals(nome)) {
				categorias.remove(i);
			}
		}
	}
	
	//Adiciona um objeto da classe RendaFixa na lista de investimentos
	public void addRendaFixa(String nome, String valorAplicado, int juros) {
		investimentos.add(new RendaFixa(nome,valorAplicado,juros));
	}
	
	//Adiciona um objeto da classe RendaVariavel na lista de investimentos
	public void addRendaVariavel(String nome, String valorAplicado, int dividendo) {
		investimentos.add(new RendaVariavel(nome,valorAplicado,dividendo));
	}
	
	//Remove um investimento da lista de investimentos selecionado pelo nome
	public void removeInvestimento(String nome) {
		for(int i=0; i<investimentos.size(); i++) {
			if (investimentos.get(i).getNome().equals(nome)) {
				investimentos.remove(i);
			}
		}
	}
	
	public void exibeReceita() {
		System.out.println("Receita");
		 
		for(int i=0; i<categorias.size(); i++) { //Exibindo todas categorias
			System.out.println(categorias.get(i).getNome() + ": "
								+ " [Valor => R$ " + categorias.get(i).getValor() + "]");
		}
		
		for(int i=0;i<investimentos.size();i++) { //Exibindo todos investimentos
			System.out.println("Investimento: [nome => " + investimentos.get(i).getNome() + "]," +
								"[ganhos => R$ "+ investimentos.get(i).ganhoTotal() + "]");
		}
		
		System.out.println("TOTAL => R$" + valorTotal());
	}

	@Override
	public String toString() {
		return "Receita [categorias=" + categorias + ", investimentos=" + investimentos + "]";
	}
	
}
