package de.leuphana.shop.component.behaviour;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.OrderPosition;
import de.leuphana.shop.connector.ShopJPAClientConnector;


@TestMethodOrder(OrderAnnotation.class)
class ShopConnectorRDBMSTest {
	
	private static ShopJPAClientConnector shopJPAClientConnector;

	@BeforeAll
	static void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-JPA-Connector.xml");
		
		shopJPAClientConnector = (ShopJPAClientConnector)applicationContext.getBean("shopJPAClientConnector");
				
		de.leuphana.shop.component.structure.Order order = new de.leuphana.shop.component.structure.Order();
		
		Set<OrderPosition> orderPositions = new HashSet<OrderPosition>();
//		Map<Integer, OrderPosition> orderPositions = new HashMap<Integer, OrderPosition>();
		
		OrderPosition orderPosition = new OrderPosition();
		orderPosition.setPositionId(1);
		orderPosition.setArticleQuantity(12);
		orderPositions.add(orderPosition);
//		orderPositions.put(1, orderPosition);
		order.setOrderPositions(orderPositions);
		
		shopJPAClientConnector.insertOrder(order);
		
		Article article = new Article();
		article.setName("New article");
		article.setManufactor("Manufactor1");
		article.setPrice(15.74f);
		
		shopJPAClientConnector.insertArticle(article);
	}

	@AfterAll
	static void tearDown() throws Exception {
		shopJPAClientConnector = null;
	}
	
	@Order(1)
	@Test
	void canArticleFoundById() {
		Assertions.assertNotNull(shopJPAClientConnector.findByArticleId(2));
	}
	
	@Order(2)
	@Test
	void areAllArticlesAvailable() {
		Assertions.assertNotNull(shopJPAClientConnector.findAllArticles());
	}
	
	@Order(3)
	@Test
	void canOrderFoundById() {
		Assertions.assertNotNull(shopJPAClientConnector.findByOrderId(1));
	}
	
	@Order(4)
	@Test
	void areAllOrdersAvailable() {
		Assertions.assertNotNull(shopJPAClientConnector.findAllOrders());
	}
	
	

}