package model;

import javax.persistence.*;

/**
 * Objeto de acesso aos dados
 * @author lucas
 *
 */
public class DAO {
	
	private static final EntityManagerFactory emFactory;
	
	static {
		emFactory = Persistence.createEntityManagerFactory("agenda");
	}

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public static void fecharFactory() {
		emFactory.close();
	}
}