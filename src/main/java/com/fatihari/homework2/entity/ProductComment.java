package com.fatihari.homework2.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product_comment")
@JsonIgnoreProperties({"userAccount", "product"})
public class ProductComment 
{
	@SequenceGenerator(name = "generator", sequenceName = "product_comment_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

	/* "comment" is a reserved word in postgreSql and it is generally not a good idea to use reserved words for identifiers (tables or columns). 
	 * Therefore, "comment_text" is preferred as the column name.
	 */
    @Column(length = 500, name = "comment_text")
    private String comment_text;

    @Column(name = "comment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date comment_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_comment_product_id"))
    private Product product;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_account_id", foreignKey = @ForeignKey(name = "fk_product_comment_user_account_id"))
    private UserAccount userAccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return "ProductComment [id=" + id + ", comment_text=" + comment_text + ", comment_date=" + comment_date
				+ ", product=" + product + ", userAccount=" + userAccount + "]";
	}

	
    
}
