package sell.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sell.project.demo.enity.Login;
import sell.project.demo.enity.User;
import sell.project.demo.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;

    public Login login(String username, String password) {
        Login user = repo.findByUsernameAndPassword(username, password);
        return user;
    }

    public boolean isValidUser(Login user) {
        return false;
    }

    public void save(Login login) {
        repo.save(login);
    }

    public Login getById(int id) {
        return repo.findById(id);
    }

}
