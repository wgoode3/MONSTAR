package com.hygogg.monstar.models;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="drinks")
public class Drink {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Size(min = 1, message="Brand is required!")
    @Size(max = 100, message="Brand must be shorter than 100 characters!")
    private String brand;
    
    @Size(min = 1, message="Name is required!")
    @Size(max = 100, message="Name must be shorter than 100 characters!")
    private String name;
    
    @Size(min = 1, message="Description is required!")
    @Size(max = 200, message="Description must be shorter than 200 characters!")
    private String description;
    
    @Min(value=0, message="Calories cannot be less than 0!")
    private Integer calories;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Drink(String brand,String name, String description, Integer calories) {
    	this.brand = brand;
    	this.name = name;
    	this.description = description;
    	this.calories = calories;
    }
    
    public Drink(Map<String, String> data) {
    	this.brand = data.get("brand");
    	this.name = data.get("name");
    	this.description = data.get("description");
    	this.calories = Integer.parseInt(data.get("calories"));
    }
    
    public Drink() {}
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getCalories() {
		return calories;
	}
	
	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public String toString() {
    	return "" + this.brand + ", " + this.name + ", " + this.description + ", " + this.calories;
    }
    
}
