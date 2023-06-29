package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.*;

public class UsuarioDAO {
	private EntityManager em;

	public UsuarioDAO() {
		super();
	}
	
	public boolean salvar(Usuario entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("erro no metodo salvar Usuario");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	public boolean remover(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Usuario entity = em.find(Usuario.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("erro no metodo remover Programador");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	public boolean buscarSenha(String senha) {
		try {
			em = JPAUtil.getEntityManager();
			Query query = em.createQuery("SELECT obj FROM Usuario obj where obj.senha= :senha");
			query.setParameter("senha", senha);
			Usuario usuario = (Usuario) query.getSingleResult();
			return true;
		}catch(NoResultException e) {
			e.printStackTrace();
			System.out.println("erro no metodo buscarSenha Usuario NoResultException ");
			return false;
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("erro no metodo buscarSenha Usuario RuntimeException");
			return false;
		} 
	}
	
	public boolean buscarEmail(String email) {
		try {
			em = JPAUtil.getEntityManager();
			Query query = em.createQuery("SELECT obj FROM Usuario obj where obj.email= :email");
			query.setParameter("email", email);
			Usuario usuario = (Usuario) query.getSingleResult();
			return true;
		} catch(NoResultException e) {
			e.printStackTrace();
			System.out.println("erro no metodo buscarEmail Usuario NoResultException ");
			return false;
		}catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("erro no metodo buscarEmail Usuario");
			return false;
		} 
	}

}
