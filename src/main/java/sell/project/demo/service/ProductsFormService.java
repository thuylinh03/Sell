package sell.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sell.project.demo.enity.Products;
import sell.project.demo.repository.ProductsReposittory;

@Service
public class ProductsFormService {
    @Autowired
    private ProductsReposittory productsReposittory;

    public List<Products> listAll() {
        return productsReposittory.findAll();
    }

    public Products saveProducts(Products products) {
        return productsReposittory.save(products);
    }

    public Products getProductsById(int id) {
        return productsReposittory.findById(id).get();
    }

    public void delete(int id) {

        productsReposittory.deleteById(id);

    }

    // public List<Products> listByCategory(int cateID) {
    // return productsReposittory.findByLoaiSanPhamId(cateID);
    // }

    public Object listCategory() {
        return null;
    }

    public Products updateProducts(Products products) {
        return productsReposittory.save(products);
    }

    public List<Products> search_products(String keyword) {
        if (keyword != null && !keyword.isBlank()) {
            List<Products> product = productsReposittory.findByNameContaining(keyword);
            return product;
        } else {
            List<Products> product = productsReposittory.findAll();
            return product;

        }
    }

    public List<Products> show_Products() {
        List<Products> product = productsReposittory.findAll();
        return product;
    }

    private List<Products> productsReposittoryRfindByNameContainingg(String keyword) {
        return null;
    }

    public static boolean isNotBlank(String str) {
        return str != null && str.trim().length() > 0;
    }

    public List<Products> getAllProducts() {
        List<Products> products = productsReposittory.findAll();
        for (Products product : products) {
            String imageUrl = product.getImage();
            if (isNotBlank(imageUrl)) {
                product.setImage(processImageUrl(imageUrl));
            } else {
                imageUrl = "https://znews-photo.zingcdn.me/w660/Uploaded/natmts/2023_02_03/z4080571344877_dcc05eb033d9e910039ad77df6eb1b05.jpg";
            }
            product.setImage(imageUrl);
        }
        return products;

    }

    private String processImageUrl(String imageUrl) {
        return null;
    }
}
