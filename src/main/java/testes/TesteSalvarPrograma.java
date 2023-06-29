package testes;
import classes.*;
import dao.*;

public class TesteSalvarPrograma {

	public static void main(String[] args) {
		Programador p1 = new Programador();
		p1.setNome("Daison");
		p1.setEndereco("Rua 123");
		p1.setEmail("Davi@123");
		p1.setSalario(1500);
		p1.setCpf("00202020");
		p1.setLinguagemProg("finton");
		p1.setProjetos("todos");
		
		//new ProgramadorDAO().salvar(p1);
		
//		for(Programador p: new ProgramadorDAO().buscarTodos()) {
//			System.out.println("\n");
//			System.out.println(p);
//		}
		System.out.println(new ProgramadorDAO().buscarCpf("0020202"));
		
		
		

	}

}
