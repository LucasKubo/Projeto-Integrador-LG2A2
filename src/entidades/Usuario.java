package entidades;

public class Usuario {
	private String nomeDoUsuario;
	private int idade;
	private String login;
	private String senha;
	
	//Construtor
	public Usuario(){}

	//getters e setters
	public String getNomeDoUsuario() {
		return nomeDoUsuario;
	}

	public void setNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [nomeDoUsuario=" + nomeDoUsuario + ", idade=" + idade + ", login=" + login + ", senha=" + senha
				+ "]";
	};
	
}
