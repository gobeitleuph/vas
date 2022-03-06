package de.leuphana.shop.connector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerToShopServerConnector {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-RMI-Connector-Server.xml");
		applicationContext.getBean("shopRmiServiceExporter");
		
		System.out.println("Shop-Server running ...");
	}

}