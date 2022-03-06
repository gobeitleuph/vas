package de.leuphana.shop.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.connector.entity.ArticleEntity;

public class ArticleMapper {
	private static Mapper mapper;
	
	static {
		// Factory method
		mapper = DozerBeanMapperSingletonWrapper.getInstance();
	}
	
	public static Article mapArticleEntityToArticle(ArticleEntity articleEntity) {
		return mapper.map(articleEntity, Article.class);
	}

	public static ArticleEntity mapArticleToArticleEntity(Article article) {
		return mapper.map(article, ArticleEntity.class);
	}

}