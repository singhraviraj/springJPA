package com.learningSpringJPA.springJPA.repository;

import com.learningSpringJPA.springJPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);

    @Query("select p from Product p where p.title=?1 and p.price=?2")
    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);
}
