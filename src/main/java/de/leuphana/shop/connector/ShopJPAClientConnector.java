package de.leuphana.shop.connector;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Order;
import de.leuphana.shop.connector.entity.ArticleEntity;
import de.leuphana.shop.connector.entity.OrderEntity;
import de.leuphana.shop.connector.mapper.ArticleMapper;
import de.leuphana.shop.connector.mapper.OrderMapper;

@Transactional
public class ShopJPAClientConnector {
	private EntityManager entityManager;

	public ShopJPAClientConnector() {
	}

	// setter-injection (Dependency injection (DI) / inversion of control (IOC))
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// ---------- insert methods --------------------------------------------------

	public void insertArticle(Article article) {
		entityManager.persist(ArticleMapper.mapArticleToArticleEntity(article));
	}

	public void insertOrder(Order order) {
		entityManager.persist(OrderMapper.mapOrderToOrderEntity(order));
	}

	// ---------- findBy methods ------------------------------------------------

	public Article findByArticleId(int id) {
		return ArticleMapper.mapArticleEntityToArticle(entityManager.find(ArticleEntity.class, id));
	}

	public Order findByOrderId(int id) {
		return OrderMapper.mapOrderEntityToOrder(entityManager.find(OrderEntity.class, id));
	}

	// ---------- findAll methods ----------------------------------------------

	// Nur R von CRUD
	public Set<Article> findAllArticles() {
		// Query
		String queryString = "SELECT * FROM ARTICLEENTITY";

		Set<Article> foundArticles = new HashSet<Article>();

		// The queryString is SQL
		Query query = entityManager.createNativeQuery(queryString, ArticleEntity.class);
		List<ArticleEntity> resultlist = query.getResultList();

		for (ArticleEntity articleEntity : resultlist) {
			foundArticles.add(ArticleMapper.mapArticleEntityToArticle(articleEntity));
		}

		return foundArticles;
	}

	public Set<Order> findAllOrders() {
		// Query
		String queryString = "SELECT * FROM ORDERENTITY";

		Set<Order> foundOrders = new HashSet<Order>();

		// The queryString is SQL
		Query query = entityManager.createNativeQuery(queryString, OrderEntity.class);
		List<OrderEntity> resultlist = query.getResultList();

		for (OrderEntity orderEntity : resultlist) {
			foundOrders.add(OrderMapper.mapOrderEntityToOrder(orderEntity));
		}

		return foundOrders;
	}
	
}