package fr.treeptik.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.GenericDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;

public abstract class GenericService<E, K> {

	public abstract GenericDAO<E, K> getDao();
	
	@Transactional
	public E save(E entite) throws ServiceException {
		try {
			entite = getDao().save(entite);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return entite;
	}

	@Transactional
	public E update(E entite) throws ServiceException {
		E updatedEntite = null;
		try {
			updatedEntite = getDao().update(entite);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return updatedEntite;
	}

	public List<E> findAll() throws ServiceException {
		List<E> findAll = null;
		try {
			findAll = getDao().findAll();
			return findAll;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public E findById(K id) throws ServiceException {
		try {
			return getDao().findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void remove(E entite) throws ServiceException {
		try {
			getDao().remove(entite);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
