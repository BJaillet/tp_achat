package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class DVD extends Article implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "DVD [Id=" + getId() + ", Prix=" + getPrix() + ", Titre=" + getTitre() + "]";
	}

}
