package flea777.springboot2.repositories;

import flea777.springboot2.handler.BusinessException;
import flea777.springboot2.handler.MustBeNotNullException;
import flea777.springboot2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user){
        if (user.getPassword() == null && user.getLogin() == null) {
            throw new BusinessException("The login and password fields must not be null");
        }

        if (user.getLogin() == null) {
            throw new MustBeNotNullException("login");
        }

        if (user.getPassword() == null) {
            throw new MustBeNotNullException("password");
        }

        if(user.getId()==null)
            System.out.println("SAVE - Receiving the user in repository layer");
        else
            System.out.println("UPDATE - Receiving the user in repository layer");

        System.out.println(user);
    }
    public void deleteById(Integer id){
        System.out.println("DELETE/id - Receiving the id: " + id + " to exclude an user");
        System.out.println(id);
    }
    public List<User> findAll(){
        System.out.println("LIST - Listing system users");
        List<User> users = new ArrayList<>();
        users.add(new User("gleyson","password"));
        users.add(new User ("pedro","masterpass"));
        return users;
    }
    public User findById(Integer id){
        System.out.println(String.format("FIND/id - Receiving the id: %d to locale an user", id));
        return new User("pedro","masterpass");
    }
    public User findByUsername(String username){
        System.out.println(String.format("FIND/username - Receiving the username: %s to locale an user", username));
        return new User("pedro","masterpass");
    }
}