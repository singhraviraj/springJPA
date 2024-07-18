package com.learningSpringJPA.springJPA;

import com.learningSpringJPA.springJPA.entity.Product;
import com.learningSpringJPA.springJPA.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LearningspringJpaApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		Product product1 = Product.builder()
				.sku("kinder56")
				.title("kinderJoy")
				.price(BigDecimal.valueOf(30.5))
				.quantity(5)
				.build();
		Product product2 = productRepository.save(product1);
		System.out.println(product2);
	}

	@Test
	void getProduct(){
		Product product = productRepository.findByTitle("pepsi");
		System.out.println(product);

	}

	@Test
	void getSingleFromRepository(){
		Optional<Product> product = productRepository.findByTitleAndPrice("kinderJoy",BigDecimal.valueOf(30.5));
		product.ifPresent(System.out::println);
	}

}
