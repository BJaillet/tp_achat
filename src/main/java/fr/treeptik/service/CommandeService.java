package fr.treeptik.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.CommandeDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Commande;

@Service
public class CommandeService extends
		GenericService<Commande, Integer> {

	@Autowired
	private CommandeDAO commandeDAO;
	
	public CommandeDAO getDao() {
		return commandeDAO;
	}

	@Transactional
	public void deleteCommande(Commande commande) throws ServiceException {

		try {
			commande = commandeDAO.findById(commande.getId());
			commandeDAO.remove(commande);
		} catch (DAOException e) {
			throw new ServiceException("", e);
		}
	}
	
	@Transactional
	public List<Commande> findByClientId(Integer clientId) throws ServiceException {

		List<Commande> commandes = new ArrayList<>();
		try {
			commandes = commandeDAO.findByClientId(clientId);
		} catch (DAOException e) {
			throw new ServiceException("", e);
		}
		
		return commandes;
	}

}
