package fr.treeptik.dao;

import org.springframework.stereotype.Repository;

import fr.treeptik.model.Article;

@Repository
public class ArticleJPADAO extends GenericJPADAO<Article, Integer> implements ArticleDAO {

	public ArticleJPADAO() {
		super(Article.class);
	}

}
