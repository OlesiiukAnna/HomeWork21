package home.Task_21;

import java.util.List;

public interface Storage {
    void removeAll();

    void removeUser(int id);//TODO

    void removeUserByName(String name);

    void addUser(User user);

    void updateUser(User user);

    User getUser(int id) throws NoSuchUserException;//TODO

    List<User> getAllUsers();
}
