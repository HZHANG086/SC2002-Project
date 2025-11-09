package services;

import java.util.HashMap;
import java.util.Map;
import models.*;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void addUser(User u) { users.put(u.getUserID(), u); }
    public User findById(String id) { return users.get(id); }


    public User authenticate(String id, String password) {
        User u = users.get(id);
        if (u != null && u.getPassword().equals(password)) return u;
        return null;
    }


    public Map<String, User> getAllUsers() { return users; }
}