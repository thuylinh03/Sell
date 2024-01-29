package sell.project.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sell.project.demo.enity.Products;

@Repository
public interface ProductsReposittory extends JpaRepository<Products, Integer> {
    List<Products> findByNameContaining(String name);

    Optional<Products> findById(int id);

    void deleteById(int id);

    // List<Products> findByLoaiSanPhamId(int cateID);

}
