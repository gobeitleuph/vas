package de.leuphana.shop.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.component.structure.Order;
import de.leuphana.shop.connector.entity.OrderEntity;

public class OrderMapper {
	private static Mapper mapper;

	static {
		mapper = DozerBeanMapperSingletonWrapper.getInstance();
	}

	public static Order mapOrderEntityToOrder(OrderEntity orderEntity) {
		return mapper.map(orderEntity, Order.class);
	}

	public static OrderEntity mapOrderToOrderEntity(Order order) {
		return mapper.map(order, OrderEntity.class);
	}

}