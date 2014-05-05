package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Livre extends Article implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String auteur;
	
	private Integer nbPages;

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Integer getNbPages() {
		return nbPages;
	}

	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return "Livre [Id=" + getId() + ", nbPages=" + nbPages
				+ ",auteur=" + auteur  + ", Prix=" + getPrix()
				+ ", Titre=" + getTitre() + "]";
	}

	

}
