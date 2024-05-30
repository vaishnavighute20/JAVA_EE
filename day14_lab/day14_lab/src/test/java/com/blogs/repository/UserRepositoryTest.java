package com.blogs.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.entities.User;
@DataJpaTest// annotation to tell spring boot test framework to enable 
// Data JPA layer .(ie service|controller|modelmapper...beans will not be activated)
@AutoConfigureTestDatabase(replace=Replace.NONE)
// tells springboot test framework - not replace oroginal data source (ie mysql)
class UserRepositoryTest {
@Autowired
private UserRepository userRepository;
	@Test// JUnit annot to indicate a test method 
	void findByEmailAndPassword(){
		Optional<User> optional=userRepository.findByEmailAndPassword("a2@gmail.com","2234");
	
		assertEquals(2l,optional.get().getId());
 	}

}
