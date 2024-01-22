package sell.project.demo.repository;

import java.lang.Long;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sell.project.demo.enity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsernameAndPassword(String username, String password);

    Login findByUsername(String username);

    Login findById(int id);
    // List<Login> findByLoginId(int loginId);
}