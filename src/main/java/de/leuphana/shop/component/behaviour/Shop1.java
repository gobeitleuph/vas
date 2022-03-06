package de.leuphana.shop.component.behaviour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.CartItem;
import de.leuphana.shop.component.structure.Catalog;
import de.leuphana.shop.component.structure.Customer;
import de.leuphana.shop.component.structure.Order;
import de.leuphana.shop.component.structure.OrderPosition;

public class Shop1 implements ShopService {
	private Catalog catalog;
	private Map<Integer, Customer> customers;
	private String jakob;
	private String patrick;


	public Shop1() {
		customers = new HashMap<Integer, Customer>();
		Integer i = Integer.valueOf(0);
		catalog = new Catalog();
	}

	@Override
	public Integer createCustomerWithCart() {
		Cart cart = new Cart();

		Customer customer = new Customer(cart);

		customers.put(customer.getCustomerId(), customer);

		return customer.getCustomerId();
	}

	@Override
	public Article getArticle(int articleId) {
		// Delegation
		return catalog.getArticle(articleId);
	}

	@Override
	public Set<Article> getArticles() {
		return catalog.getArticles();
	}

	@Override
	public void removeArticleFromCart(Integer customerId, int articleId) {
		// Delegation
		Cart cart = customers.get(customerId).getCart();

		cart.deleteCartItem(articleId);
	}

	@Override
	public void addArticleToCart(Integer customerId, Integer articleId) {
		Article foundArticle = getArticle(articleId);

		Cart cart = customers.get(customerId).getCart();

		cart.addCartItem(foundArticle);
	}

	@Override
	public void decrementArticleQuantityInCart(Integer customerId, Integer articleId) {
		Cart cart = customers.get(customerId).getCart();

		cart.decrementArticleQuantity(articleId);
	}

	@Override
	public Order checkOutCart(int customerId) {

		Customer customer = customers.get(customerId);
		Cart cart = customer.getCart();

		Order order = new Order();
		order.setOrderId(1);

		int i = 1;

		Set<OrderPosition> orderPositions = new HashSet<OrderPosition>();

		for (CartItem cartItem : cart.getCartItems()) {
			OrderPosition orderPosition = new OrderPosition();
			orderPosition.setPositionId(i++);
			orderPosition.setArticle(cartItem.getArticle());
			orderPosition.setArticleQuantity(cartItem.getQuantity());
			orderPositions.add(orderPosition);
			order.setOrderPositions(orderPositions);
		}

		customer.addOrder(order);

		return order;
	}

	@Override
	public Cart getCartForCustomer(Integer customerId) {
		return customers.get(customerId).getCart();
	}

}
