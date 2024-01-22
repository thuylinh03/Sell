package sell.project.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sell.project.demo.enity.User;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    List<User> findByNameContaining(String name);

    Optional<User> findById(int id);

    User findByLoginId(int loginId);

}