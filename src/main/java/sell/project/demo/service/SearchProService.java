package sell.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sell.project.demo.enity.Products;
import sell.project.demo.repository.ProductsReposittory;

@Service
public class SearchProService {
    @Autowired
    private ProductsReposittory productsRepository;

    public static boolean isNotBlank(String str) {
        return str != null && str.trim().length() > 0;
    }

    public List<Products> search(String keyword) {
        if (keyword != null && !keyword.isBlank()) {
            List<Products> products = productsRepository.findByNameContaining(keyword);
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
        } else {
            List<Products> products = productsRepository.findAll();
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

    }

    private String processImageUrl(String imageUrl) {
        return null;
    }

    public Products getById(int id) {
        return productsRepository.findById(id).get();
    }

    public List<Products> getAll() {
        List<Products> products = productsRepository.findAll();
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

}
