package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;
@Component
public interface UserDao {
    void add (User user);
    void delete (int id);
    void update (User user);
    List<User> findAll();
    User findById(int id);
}
