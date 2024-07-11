package com.blogs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogs.dto.CategoryDTO;
@SpringBootTest// anno for the spring boot test framework to enable all spring bean
//including controller,service and daobeans
class CategoryServiceTest {
@Autowired
private CategoryService categoryService;

	@Test
	void test() {
	assertNotNull(categoryService);
	}
	@Test
	void getAllCategories() {
		List<CategoryDTO>list=categoryService.getAllCategories();
		assertEquals(2, list.size());
		list.forEach(System.out::println);
	}
	

}
