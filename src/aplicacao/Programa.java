package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Conta;
import entidades.Despesa;
import entidades.Receita;
import entidades.Usuario;
import servicos.UsuarioService;

public class Programa {
	public static void main(String[] args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Usuario usuario = new Usuario();

		// Iniciando aplicação
		System.out.println("*****GESTÃO DE FINANÇAS*****");

		System.out.println("============================");
		System.out.println("Cadastrar");

		// Realizando cadastro de usuário
		while (true) {
			System.out.print("Informe seu nome: ");
			String nomeDeUsuario = sc.nextLine();
			System.out.print("Informe sua idade: ");
			int idade = sc.nextInt();
			sc.nextLine();
			System.out.print("Informe seu login: ");
			String loginDeCadastro = sc.nextLine();
			System.out.print("Informe sua senha: ");
			String senhaDeCadastro = sc.nextLine();

			if (UsuarioService.cadastraUsuario(usuario, nomeDeUsuario, idade, loginDeCadastro, senhaDeCadastro)) {
				;
				System.out.println();
				System.out.println("Cadastro realizado com sucesso !");
				System.out.println();
				break;
			} else {
				System.out.println();
				System.out.println("Usuário não pode ser menor de idade !");
				System.out.println();
			}
		}

		System.out.println("============================");
		System.out.println("Entrar");

		// Realizando login do usuário
		while (true) {
			System.out.print("Login:");
			String login = sc.nextLine();
			System.out.print("Senha:");
			String senha = sc.nextLine();
			if (UsuarioService.validaAcesso(usuario, login, senha)) {
				System.out.println();
				System.out.println("Seja bem vindo " + usuario.getNomeDoUsuario());
				System.out.println();
				break;
			} else {
				System.out.println();
				System.out.println("Login ou senha incorreto(s)");
				System.out.println();
			}
		}
		// Instanciando receita e despesa
		Despesa despesa = new Despesa();
		Receita receita = new Receita();
		// Lendo dados da conta bancária
		System.out.println("============================");
		System.out.println("Informe os dados de sua conta bancária: ");

		System.out.print("Nome do banco: ");
		String nomeDoBanco = sc.nextLine();
		System.out.print("Saldo atual: ");
		String saldoAtual = sc.nextLine();
		Conta conta = new Conta(usuario, nomeDoBanco, saldoAtual, receita, despesa);

		int escolha = 0;
		// Exibindo menu principal:
		do {
			System.out.println("============================");
			System.out.println("Menu");
			System.out.println("1- Despesas");
			System.out.println("2- Receita");
			System.out.println("3- Informações da conta");
			System.out.println("4- Sair");
			System.out.print("Escolha uma opção => ");
			escolha = sc.nextInt();
			System.out.println();

			switch (escolha) {
			case 1:
				// menu de despesas
				int escolhaDespesa = 0;
				do {
					System.out.println("============================");
					System.out.println("Despesas");
					System.out.println("1- Acrescentar despesas");
					System.out.println("2- Excluir despesa");
					System.out.println("3- Ver despesa");
					System.out.println("4- Voltar");
					System.out.print("Escolha uma opção => ");
					escolhaDespesa = sc.nextInt();
					sc.nextLine();
					System.out.println();
					switch (escolhaDespesa) {
					case 1:
						System.out.println("============================");
						System.out.println("Acrescentar");
						System.out.println("1- Transferência");
						System.out.println("2- Fatura");
						System.out.println("3- Outras categorias");
						System.out.print("Escolha uma opção => ");
						escolhaDespesa = sc.nextInt();
						sc.nextLine();
						System.out.println();
						if (escolhaDespesa == 1) {
							System.out.println("============================");
							System.out.print("Nome do destinatário da transferência: ");
							String nomeDestinatario = sc.nextLine();
							System.out.print("Data da transferência: ");
							String dataTransferencia = sc.nextLine();
							System.out.print("Valor transferido: ");
							String valorTransferido = sc.nextLine();
							despesa.addTransacao(nomeDestinatario, dataTransferencia, valorTransferido);
							System.out.println();
							System.out.println("Transferência registrada com sucesso !");
							System.out.println();
						} else if (escolhaDespesa == 2) {
							System.out.println("============================");
							System.out.println("Cartão já registrado ?");
							System.out.println("1- Sim");
							System.out.println("2- Não");
							int resposta = sc.nextInt();
							sc.nextLine();
							if (resposta == 1) {
								System.out.print("Nome do banco: ");
								nomeDoBanco = sc.nextLine();
								System.out.print("Nova fatura: ");
								String novaFatura = sc.nextLine();

								for (int i = 0; i < despesa.getCartoesDeCredito().size(); i++) {
									if (despesa.getCartoesDeCredito().get(i).getNomeDoBanco().equals(nomeDoBanco)) {
										despesa.getCartoesDeCredito().get(i).setValorDaFatura(novaFatura);
									}
								}
							} else if (resposta == 2) {
								System.out.println("Registro de novo cartão");
								System.out.print("Nome do banco: ");
								nomeDoBanco = sc.nextLine();
								System.out.print("Nome do titular: ");
								String nomeDoTitular = sc.nextLine();
								System.out.print("Número do cartão: ");
								String numDoCartao = sc.nextLine();
								System.out.print("Limite: ");
								String limiteDoCartao = sc.nextLine();
								System.out.print("Fatura: ");
								String valorDaFatura = sc.nextLine();
								despesa.addCartao(nomeDoBanco, nomeDoTitular, numDoCartao, limiteDoCartao,
										valorDaFatura);
							}
						} else if (escolhaDespesa == 3) {
							System.out.println("============================");
							System.out.print("Categoria (exemplo: transporte, alimentação etc): ");
							String nomeCategoria = sc.nextLine();
							System.out.print("Valor: ");
							String valorCategoria = sc.nextLine();
							despesa.addCategoria(nomeCategoria, valorCategoria);
						}
						break;
					case 2:
						System.out.println("============================");
						System.out.println("Excluir");
						System.out.println("Nome da despesa: ");
						String nomeDespesa = sc.nextLine();
						System.out.println();
						despesa.removeCategoria(nomeDespesa);
						break;
					case 3:
						despesa.listarDespesas();
						break;
					}
				} while (escolhaDespesa != 4);
				break;

			case 2:
				// menu de receita
				int escolhaReceita = 0;
				do {
					System.out.println("============================");
					System.out.println("Receitas");
					System.out.println("1- Acrescentar nova fonte de receita");
					System.out.println("2- Excluir receita");
					System.out.println("3- Exibir receita");
					System.out.println("4- Voltar");
					System.out.print("Escolha uma opção => ");
					escolhaReceita = sc.nextInt();
					sc.nextLine();
					System.out.println();

					switch (escolhaReceita) {
					case 1:
						System.out.println("============================");
						System.out.println("Acrescentar");
						System.out.println("1- Investimento");
						System.out.println("2- Outras categorias");
						System.out.print("Escolha uma opção => ");
						escolhaReceita = sc.nextInt();
						sc.nextLine();
						System.out.println();

						if (escolhaReceita == 1) {
							System.out.println("============================");
							System.out.println("Investimento");
							System.out.println("1- Renda fixa");
							System.out.println("2- Renda variável");
							System.out.print("Escolha uma opção => ");
							int opcao = sc.nextInt();
							sc.nextLine();
							System.out.println();
							if (opcao == 1) {
								System.out.print("Nome do investimento: ");
								String nomeRendaFixa = sc.nextLine();
								System.out.print("Valor aplicado: ");
								String valorRendaFixa = sc.nextLine();
								System.out.print("Juros (%): ");
								int jurosRendaFixa = sc.nextInt();
								sc.nextLine();
								receita.addRendaFixa(nomeRendaFixa, valorRendaFixa, jurosRendaFixa);
							} else if (opcao == 2) {
								System.out.print("Nome do investimento: ");
								String nomeRendaVariavel = sc.nextLine();
								System.out.print("Valor aplicado: ");
								String valorRendaVariavel = sc.nextLine();
								System.out.print("Dividendo: ");
								int dividendoRendaVariavel = sc.nextInt();
								sc.nextLine();
								receita.addRendaVariavel(nomeRendaVariavel, valorRendaVariavel, dividendoRendaVariavel);
							}
						} else if (escolhaReceita == 2) {
							System.out.println("============================");
							System.out.print("Categoria (exemplo: trabalho vonluntário, hora extra, salário etc): ");
							String nomeCategoria = sc.nextLine();
							System.out.print("Valor: ");
							String valorCategoria = sc.nextLine();
							receita.addCategoria(nomeCategoria, valorCategoria);
						}
						break;
					case 2:
						System.out.println("============================");
						System.out.println("Excluir");
						System.out.print("Nome da receita: ");
						String nomeReceita = sc.nextLine();
						System.out.println();
						receita.removeCategoria(nomeReceita);
						break;
					case 3:
						System.out.println("============================");
						receita.exibeReceita();
						break;
					}
				} while (escolhaReceita != 4);
				break;

			case 3:
				System.out.println("============================");
				System.out.println("Conta");
				conta.exibeConta();
				break;
			}
		} while (escolha != 4);

		sc.close();
	}
}
