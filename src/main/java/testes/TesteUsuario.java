package testes;
import classes.*;
import dao.*;
public class TesteUsuario {

	public static void main(String[] args) {
		Usuario s1= new Usuario();
		s1.setEmail("Davi@");
		s1.setSenha("123");
		
		//new UsuarioDAO().salvar(s1);
		if(new UsuarioDAO().buscarEmail("Davi@")) {
			System.out.println("Tudo ok");
		}else System.out.println("Erro");

	}

}
