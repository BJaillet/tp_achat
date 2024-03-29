package fr.treeptik.dao;

import org.springframework.stereotype.Repository;

import fr.treeptik.model.Client;

@Repository
public class ClientJPADAO extends GenericJPADAO<Client, Integer> implements ClientDAO {

	public ClientJPADAO() {
		super(Client.class);
	}

}
