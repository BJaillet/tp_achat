package fr.treeptik.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.model.Commande;

@Service
public class ClientService extends GenericService<Client, Integer> {

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private CommandeService commandeService;

	@Override
	public ClientDAO getDao() {
		return clientDAO;
	}

	@Transactional
	public Client saveClientCommandes(Client client, Commande commande)
			throws ServiceException {

		try {
			commande = commandeService.save(commande);
			List<Commande> commandes = new ArrayList<>();
			commandes.add(commande);
			client.setCommandes(commandes);
			client = clientDAO.save(client);
			commande.setClient(client);
		} catch (ServiceException | DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return client;
	}
	
	@Transactional
	public void deleteClient(Client client)
			throws ServiceException {
		try {
			client = clientDAO.findById(client.getId());
			clientDAO.remove(client);
		} catch (DAOException e) {
			throw new ServiceException("", e);
		}
	}
	
	@Transactional
	public void deleteClientCommandes(Client client)
			throws ServiceException {
		try {
			for (Commande commande : client.getCommandes()) {
				commandeService.deleteCommande(commande);
			}
			deleteClient(client);
		} catch (ServiceException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public Client findByIdWithCommandes(Integer id)
			throws ServiceException {
		Client client;
		
		try {
			client = clientDAO.findById(id);
			
			client.setCommandes(commandeService.findByClientId(id));
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
		return client;
	}

}