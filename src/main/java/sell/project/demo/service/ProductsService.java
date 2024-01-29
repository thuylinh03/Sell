package sell.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sell.project.demo.enity.Login;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import eatclean.project.demo.repository.ProductsRepository;
import sell.project.demo.enity.Products;

// @Service

public interface ProductsService {

    List<Products> getAllProducts();

    Products saveProducts(Products product);

    Products getProductsById(int id);

    Products updateProducts(Products product);

    void deleteProductsById(int id);

}
