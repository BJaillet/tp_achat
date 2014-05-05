package fr.treeptik.runtime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Article;
import fr.treeptik.model.CD;
import fr.treeptik.model.Client;
import fr.treeptik.model.Commande;
import fr.treeptik.model.DVD;
import fr.treeptik.model.Livre;
import fr.treeptik.service.ArticleService;
import fr.treeptik.service.ClientService;
import fr.treeptik.service.CommandeService;

public class Runtime {

	public static Logger logger = Logger.getLogger(Runtime.class);

	public static void main(String[] args) throws ServiceException {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ArticleService articleService = context.getBean(ArticleService.class);

		ClientService clientService = context.getBean(ClientService.class);

		CommandeService commandeService = context
				.getBean(CommandeService.class);

//		CD cd1 = new CD();
//		cd1.setAuteur("chanteur1");
//		cd1.setPrix(1);
//		cd1.setTitre("musique1");
//
//		CD cd2 = new CD();
//		cd2.setAuteur("chanteur2");
//		cd2.setPrix(10);
//		cd2.setTitre("musique2");
//
//		Livre livre1 = new Livre();
//		livre1.setAuteur("auteur1");
//		livre1.setNbPages(8);
//		livre1.setPrix(2);
//		livre1.setTitre("livre1");
//
//		Livre livre2 = new Livre();
//		livre2.setAuteur("auteur2");
//		livre2.setNbPages(57);
//		livre2.setPrix(14);
//		livre2.setTitre("livre2");
//
//		DVD dvd1 = new DVD();
//		dvd1.setPrix(20);
//		dvd1.setTitre("film1");
//
//		List<Article> articles = new ArrayList<>();
//		articles.add(cd1);
//		articles.add(cd2);
//		articles.add(livre1);
//		articles.add(livre2);
//		articles.add(dvd1);

//		for (Article article : articles) {
//			articleService.save(article);
//		}

//		Commande commande = new Commande();
//		commande.setDateLivraison(new Date());
//		commande.setArticles(articles);
//		commande.calculateTotal();
//		List<Commande> commandes = new ArrayList();
//		commandes.add(commande);

		Client client = clientService.findByIdWithCommandes(1);
//		Client client = new Client();
//		client.setAdresse("rue du quai");
//		client.setNom("haliday");
//		client.setPrenom("johnny");
		
//		client.setCommandes(commandes);
//		commande.setClient(client);

		try {

			clientService.deleteClientCommandes(client);

		} catch (ServiceException e) {
			e.printStackTrace();
		}

		//logger.debug(client);

		context.close();
	}

}
