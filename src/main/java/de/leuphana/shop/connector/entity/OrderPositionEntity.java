package de.leuphana.shop.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderPositionEntity {

	// intrinsic attributes
	private Integer positionId;
	private int articleQuantity;
	
	// relational attributes
//	private ArticleEntity articleEntity;
	
	@Id
	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

//	public ArticleEntity getArticleEntity() {
//		return articleEntity;
//	}
//  
//	@OneToOne(cascade=CascadeType=ALL, fetch=FetchType.LAZY)
//	public void setArticleEntity(ArticleEntity articleEntity) {
//		this.articleEntity = articleEntity;
//	}

	public int getArticleQuantity() {
		return articleQuantity;
	}

	public void setArticleQuantity(int articleQuantity) {
		this.articleQuantity = articleQuantity;
	}

}