package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {
	@Column(length = 50,unique = true)
	private String name;
	private String description;
// for adding category --> *blogspost
	// alwyas initialize a collection to emepty
	/*
	 * mappedby -- mandatory in bi direction association only
	 * where -- appers in the inverse (non owning)
	 * value-- name of the ass properties as it appears in the owning side
	 * 
	 */
	@OneToMany(mappedBy="chosenCategory")
	private List<BlogPost>Posts=new ArrayList<>();// project tip
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	

	public List<BlogPost> getPosts() {
		return Posts;
	}
	public void setPosts(List<BlogPost> posts) {
		Posts = posts;
	}
	@Override
	public String toString() {
		return "Category " + getId() + " [name=" + name + ", description=" + description + "]";
	}

}
