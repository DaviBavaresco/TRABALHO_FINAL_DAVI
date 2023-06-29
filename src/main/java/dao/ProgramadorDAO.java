package dao;

import java.util.List;


import classes.Programador;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;






public class ProgramadorDAO {
	private EntityManager em;

	public ProgramadorDAO() {
		super();
	}
	
	public boolean salvar(Programador entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("erro no metodo salvar Paciente");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public List<Programador> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Programador> query = em.createQuery("SELECT obj FROM Programador obj", Programador.class);
			List<Programador> programadores = query.getResultList();
			return programadores;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}

	public Programador buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Programador entity = em.find(Programador.class, id);
			return entity;
		} catch (RuntimeException e) {
			System.out.println("erro no metodo buscarId Programador");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	public Programador buscarNome(String nome) {
		try {
			em = JPAUtil.getEntityManager();
			Programador entity = em.find(Programador.class,nome);
			return entity;
		} catch (RuntimeException e) {
			System.out.println("erro no metodo buscarNome Programador");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}
	
	
	public boolean remover(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Programador entity = em.find(Programador.class, id);
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
	
	public boolean atualizar(Programador entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			System.out.println("erro no metodo atualizar Progamador");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}
	public Programador buscarCpf(String cpf) {
		try {
			em = JPAUtil.getEntityManager();
			Query query = em.createQuery("SELECT obj FROM Programador obj where obj.cpf= :cpf");
			query.setParameter("cpf", cpf);
			Programador programador = (Programador) query.getSingleResult();
			return programador;
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("erro no metodo buscarEspecialidade Medico");
			return null;
		} 
	}
}
