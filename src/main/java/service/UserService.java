package service;

import dao.UserDAO;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public boolean register(String name, String email, String password, String role) {

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(
            name,
            email,
            hashedPassword,
            role
        );

        return userDAO.register(user);
    }

    public User login(String email, String password) {

        User user = userDAO.findByEmail(email);

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }

        return null;
    }
}