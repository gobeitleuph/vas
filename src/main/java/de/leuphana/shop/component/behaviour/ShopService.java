package de.leuphana.shop.component.behaviour;

import java.util.Set;

import de.leuphana.shop.component.structure.Article;
import de.leuphana.shop.component.structure.Cart;
import de.leuphana.shop.component.structure.Order;

public interface ShopService {

	Integer createCustomerWithCart();

	Article getArticle(int articleId);

	Set<Article> getArticles();

	void removeArticleFromCart(Integer customerId, int articleId);

	void addArticleToCart(Integer customerId, Integer articleId);

	void decrementArticleQuantityInCart(Integer customerId, Integer articleId);

	Order checkOutCart(int customerId);

	Cart getCartForCustomer(Integer customerId);

}