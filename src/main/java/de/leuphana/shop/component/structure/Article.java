package de.leuphana.shop.component.structure;

import java.io.Serializable;

// POJO (Plain old java object; fachlich, es gibt keine Technologie in Form von Vererbung, Annotation, ....
// hier kein POJO wg. RMI (Serializable), da das Serializable invasive ist
// Java Bean
public class Article implements Serializable {

	private Integer articleId;
	private String manufactor;
	private String name;
	private float price;

	public Article() {
	}
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public String getManufactor() {
		return manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}