package de.leuphana.shop.component.structure;

import java.util.HashSet;
import java.util.Set;

public class Order {

	private Integer orderId;
//	private int customerId;
	// 1:M relation
	private Set<OrderPosition> orderPositions;

	public Order() {
		orderPositions = new HashSet<OrderPosition>();
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	
//	public int getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
	
	public Set<OrderPosition> getOrderPositions() {
		return orderPositions;
	}
	
	public void setOrderPositions(Set<OrderPosition> orderPositions) {
		this.orderPositions = orderPositions;
	}

	public int getNumberOfArticles() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getTotalPrice() {
		double totalPrice = 0.0;

		Article article;
		for (OrderPosition orderPosition : orderPositions) {
			article = orderPosition.getArticle();

			totalPrice += orderPosition.getArticleQuantity() * article.getPrice();
		}

		return totalPrice;
	}

}