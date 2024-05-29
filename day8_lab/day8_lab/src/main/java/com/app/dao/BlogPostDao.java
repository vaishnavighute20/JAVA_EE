package com.app.dao;
import com.app.entities.BlogPost;
import com.app.entities.Category;
public interface BlogPostDao {
// add a new blog post
 String createNewBlog(BlogPost Post, Long CategoryId,Long autherId) ;
	
	
	
}
