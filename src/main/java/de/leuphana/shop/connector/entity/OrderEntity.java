package de.leuphana.shop.connector.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class OrderEntity {

	// intrinsic attributes
	private Integer orderId;
	
	// relational attributes
//	private int customerId;
	// relation - aggregation
	private Set<OrderPositionEntity> orderPositions;
	
	public OrderEntity() {
		orderPositions = new HashSet<OrderPositionEntity>();
	}
	
	@Id
	@GeneratedValue
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

//	public int getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "fk_orderId", referencedColumnName = "orderId")
	public Set<OrderPositionEntity> getOrderPositions() {
		return orderPositions;
	}

	public void setOrderPositions(Set<OrderPositionEntity> orderPositions) {
		this.orderPositions = orderPositions;
	}

}