package com.fatihari.homework2.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductCommentDTO 
{
	private Long id;

    private String comment_text;

    private Date comment_date;

    private Long product_id;
    
    private Long user_account_id;

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

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Long getUser_account_id() {
		return user_account_id;
	}

	public void setUser_account_id(Long user_account_id) {
		this.user_account_id = user_account_id;
	}
}
