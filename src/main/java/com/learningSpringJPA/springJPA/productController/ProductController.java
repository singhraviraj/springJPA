package com.learningSpringJPA.springJPA.productController;

import com.learningSpringJPA.springJPA.entity.Product;
import com.learningSpringJPA.springJPA.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private final int PageSize = 5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public List<Product> getProduct(@RequestParam(defaultValue = "Id") String sortBy){
//        //sorting by calling method names
////        return productRepository.findByOrderByPrice();
//
//        //sorting by using sort class
//        //return productRepository.findBy(Sort.by(sortBy));
//
//        //implementing pagination
//        return productRepository.findAll();
//        }

    @GetMapping
    public List<Product> getProduct(@RequestParam(defaultValue = "0") Integer pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,PageSize);
        return productRepository.findAll(pageable).toList();
    }
    }

