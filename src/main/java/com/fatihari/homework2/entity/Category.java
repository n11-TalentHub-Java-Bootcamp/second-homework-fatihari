package com.fatihari.homework2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category 
{
	@SequenceGenerator(name = "generator", sequenceName = "category_id_seq")
    @GeneratedValue(generator = "generator")
	@Id
    @Column(name = "id", nullable = false)
    private Long id;

    
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "refractive") // Kırılım
    private Long refractive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upper_category_id")
    private Category upper_category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRefractive() {
		return refractive;
	}

	public void setRefractive(Long refractive) {
		this.refractive = refractive;
	}

	public Category getUpper_category() {
		return upper_category;
	}

	public void setUpper_category(Category upper_category) {
		this.upper_category = upper_category;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", refractive=" + refractive + ", upper_category="
				+ upper_category + "]";
	}
}
