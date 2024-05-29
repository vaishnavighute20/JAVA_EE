package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//title, description, content
@Entity
@Table(name = "posts")
public class BlogPost extends BaseEntity {
	@Column(length = 50,unique = true)
	private String title;
	@Column(length = 100)
	private String description;
	@Column(length = 500)
	private String content;
   // blogpost *-->1 category
	@ManyToOne
	
	// optional but recommended to specify name of the foreign key column + not null constraints
	@JoinColumn(name="category_id",nullable=false)
	private Category chosenCategory;
	// BlogsPost*-->1 User(author)
	@ManyToOne
	@JoinColumn(name="author_id",nullable=false)

	private User author;
	
	
	public BlogPost() {
		// TODO Auto-generated constructor stub
	}

	public BlogPost(String title, String description, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getChosenCategory() {
		return chosenCategory;
	}

	public void setChosenCategory(Category chosenCategory) {
		this.chosenCategory = chosenCategory;
	}
	//  tip -- never add any association based properties in toString 
	// other wise on a bi direction cause stack overflow

	@Override
	public String toString() {
		return "BlogPost [title=" + title + ", description=" + description + ", content=" + content + "]";
	}
	

}
