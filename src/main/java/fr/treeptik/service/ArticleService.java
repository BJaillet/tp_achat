package fr.treeptik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.model.Article;

@Service
public class ArticleService extends GenericService<Article, Integer> {

	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public ArticleDAO getDao() {
		return articleDAO;
	}

}
