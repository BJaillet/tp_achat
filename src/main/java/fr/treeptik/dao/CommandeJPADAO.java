package fr.treeptik.dao;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Commande;

@Repository
public class CommandeJPADAO extends GenericJPADAO<Commande, Integer> implements CommandeDAO {
	
	public CommandeJPADAO() {
		super(Commande.class);
	}
	
	public List<Commande> findByClientId(Integer clientId) throws DAOException {
		TypedQuery<Commande> query = entityManager.createQuery("select c from Commande c where c.client.id = :id", Commande.class);
		query.setParameter("id", clientId);
		try {
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur find by client id", e);
		}
	}
}
