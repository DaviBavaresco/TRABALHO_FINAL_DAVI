package classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import dao.ProgramadorDAO;

/**
 * Entity implementation class for Entity: Programador
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "idProgramador", referencedColumnName = "idFuncionario")
public class Programador extends Funcionario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String linguagemProg;
	private String projetos;

	public Programador() {
		super();
	}

	public Programador(String linguagemProg, String projetos) {
		super();
		this.linguagemProg = linguagemProg;
		this.projetos = projetos;
	}

	public String getLinguagemProg() {
		return linguagemProg;
	}

	public void setLinguagemProg(String linguagemProg) {
		this.linguagemProg = linguagemProg;
	}

	public String getProjetos() {
		return projetos;
	}

	public void setProjetos(String projetos) {
		this.projetos = projetos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(linguagemProg, projetos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programador other = (Programador) obj;
		return Objects.equals(linguagemProg, other.linguagemProg) && Objects.equals(projetos, other.projetos);
	}

	@Override
	public String toString() {
		return "Programador [linguagemProg=" + linguagemProg + ", projetos=" + projetos + ", getIdFuncionario()="
				+ getIdFuncionario() + ", getNome()=" + getNome() + ", getEndereco()=" + getEndereco() + ", getEmail()="
				+ getEmail() + ", getSalario()=" + getSalario() + ", getCpf()=" + getCpf() + "]";
	}
	public boolean salvar() {
		return new ProgramadorDAO().salvar(this);
	}
	public List<Programador> buscarTodos(){
		return new ProgramadorDAO().buscarTodos();
	}
	public boolean atualizar(){
		return new ProgramadorDAO().atualizar(this);
	}
	public boolean remover(){
		return new ProgramadorDAO().remover(this.getIdFuncionario());
	}
	public Programador buscarID(){
		return new ProgramadorDAO().buscarID(this.getIdFuncionario());
	}
	public Programador buscarNome(){
		return new ProgramadorDAO().buscarNome(this.getNome());
	}
	public Programador buscarCpf(){
		return new ProgramadorDAO().buscarCpf(this.getCpf());
	}
}
