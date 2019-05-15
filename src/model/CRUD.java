package model;

import org.hibernate.HibernateError;
import javax.persistence.*;
import java.util.List;

/**
 * Classe CRUD para interagir com o banco
 * @author lucas
 * @see javax.persistence
 * @since 1.0
 */
public class CRUD {
	
	/**
	 * Insere um contato no banco
	 * @param c1 Objeto de Contato a ser inserido no banco
	 */
	public static void inserir(Contato c1) {
		try {
			EntityManager entityManager = DAO.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(c1);
			entityManager.getTransaction().commit();
			entityManager.close();
			//System.out.println("Contato salvo");
		} catch (HibernateError ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Lista todos os contatos salvos no banco
	 * @return retorna uma lista de contatos List Contato
	 */
	public static List<Contato> ler() {
		EntityManager entityManager = DAO.getEntityManager();
		entityManager.getTransaction().begin();
		List<Contato> contatos = entityManager.createQuery("SELECT c FROM Contato c", model.Contato.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return contatos;
	}  
	
	/**
	 * Atualiza um contato no banco
	 * @param id id do contato a ser atualizado
	 * @param nome coluna nome
	 * @param sobrenome coluna sobrenome
	 * @param telefone coluna telefone
	 * @param email coluna email
	 */
	public static void atualizar(int id, String nome, String sobrenome, String telefone, String email) {
		try {
			EntityManager entityManager = DAO.getEntityManager();
			Contato emp = entityManager.find(Contato.class, new Integer(id));
			entityManager.getTransaction().begin();
			emp.setNome(nome);
			emp.setSobrenome(sobrenome);
			emp.setTelefone(telefone);
			emp.setEmail(email);
			entityManager.getTransaction().commit();
			entityManager.close();
			//System.out.println("Registro atualizado");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Remove um contato do banco
	 * @param id id do contato a ser removido
	 */
	public static void remover(int id) {
		try {
			EntityManager entityManager = DAO.getEntityManager();
			entityManager.getTransaction().begin();
			Contato c = entityManager.find(Contato.class, new Integer(id));
			entityManager.remove(c);
			entityManager.getTransaction().commit();
			entityManager.close();
			//System.out.println("Registro removido");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
