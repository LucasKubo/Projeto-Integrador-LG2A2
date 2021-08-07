package servicos;

import entidades.Usuario;

public class UsuarioService {
	
	public static boolean cadastraUsuario(Usuario usuario, String nome, int idade, String login, String senha){
		if(idade >= 18) {  //Verifica se o usuário é maior de idade
			usuario.setNomeDoUsuario(nome);
			usuario.setIdade(idade);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			return true;
		}
		return false;
	}
	
	public static boolean validaAcesso (Usuario usuario, String login, String senha) {
		if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}
}
