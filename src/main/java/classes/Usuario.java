package classes;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import dao.ProgramadorDAO;
import dao.UsuarioDAO;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private Long idUsuario;
	private String email;
	private String senha;

	public Usuario() {
		super();
	}

	

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, idUsuario, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(senha, other.senha);
	}
	
   @Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", email=" + email + ", senha=" + senha + "]";
	}
   public boolean salvar() {
		return new UsuarioDAO().salvar(this);
	}
   public boolean remover(){
		return new UsuarioDAO().remover(this.getIdUsuario());
	}
   public boolean buscarEmail(){
		return new UsuarioDAO().buscarEmail(this.getEmail());
	}
   public boolean buscarSenha(){
		return new UsuarioDAO().buscarSenha(this.getSenha());
	}
}
